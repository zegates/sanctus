package com.zegates.sanctus.beans;

import com.zegates.sanctus.entity.LogSession;
import com.zegates.sanctus.entity.OrderDetail;
import com.zegates.sanctus.entity.Orders;
import com.zegates.sanctus.remote.RemoteDBHandler;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@Stateless
public class OrdersBeanImpl implements com.zegates.sanctus.beans.remote.OrdersBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Orders orders) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.persist(orders);

            try {
                RemoteDBHandler.setData("INSERT INTO orders  (`OID`, `ADDRESS`, `CUSTNAME`, `DATEADDED`,"
                        + " `DISCOUNT`, `PAIDAMOUNT`, `TIMEADDED`, `TOTAL`, `TPNO`, `LOGSESSION_SEID`)"
                        + " VALUES ('" + orders.getOid() + "', '" + orders.getAddress() + "', '" + orders.getCustName() + "', "
                        + "'" + orders.getDateAdded() + "', '" + orders.getDiscount() + "', '" + orders.getPaidAmount() + "', '" + orders.getTimeAdded() + "',"
                        + " '" + orders.getTotal() + "', '" + orders.getTpNo() + "', '" + orders.getLogSession().getSeid() + "')");
                List<OrderDetail> orderDetails = orders.getOrderDetails();
                List<Long> odids = new ArrayList<>();

                for (int i = 0; i < orderDetails.size(); i++) {
                    OrderDetail orderDetail = orderDetails.get(i);
                    if (!odids.contains(orderDetail.getOdid())) {
                        odids.add(orderDetail.getOdid());
                        RemoteDBHandler.setData("INSERT INTO `orderdetail` (`ODID`, `QTY`, `UNITPRICE`, "
                                + "`ORDER_OID`, `SUPPLYORDERDETAIL_SODID`) "
                                + "VALUES ('" + orderDetail.getOdid() + "', '" + orderDetail.getQty() + "',"
                                + " '" + orderDetail.getUnitPrice() + "', '" + orderDetail.getOrder().getOid() + "', "
                                + "'" + orderDetail.getSupplyOrderDetail().getSodid() + "')");
                    }
                }
            } catch (Exception ce) {
                System.out.println("Remote Error");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void edit(Orders orders){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.merge(orders);
        }  catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orders orders;
            orders = em.getReference(Orders.class, id);
            orders.getOid();

            LogSession logSession = orders.getLogSession();
            if (logSession != null) {
                logSession.getOrderss().remove(orders);
                logSession = em.merge(logSession);
            }
            List<OrderDetail> orderDetails = orders.getOrderDetails();
            for (OrderDetail orderDetailsOrderDetail : orderDetails) {
                orderDetailsOrderDetail.setOrder(null);
                orderDetailsOrderDetail = em.merge(orderDetailsOrderDetail);
            }
            em.remove(orders);
            try{
                List<OrderDetail> orderDetails1 = orders.getOrderDetails();
                for (int i = 0; i < orderDetails1.size(); i++) {
                    OrderDetail orderDetail = orderDetails1.get(i);
                    RemoteDBHandler.setData("DELETE FROM `orderdetail` WHERE `odid`="+orderDetail.getOdid()+"");
                }
                RemoteDBHandler.setData("DELETE FROM `orders` WHERE `oid`="+orders.getOid()+"");


            }  catch (Exception ex) {
                ex.printStackTrace();
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Orders> findOrdersEntities() {
        return findOrdersEntities(true, -1, -1);
    }

    @Override
    public List<Orders> findOrdersEntitiesPaidfalse(boolean paid) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT o FROM Orders o WHERE o.paid=" + paid);
        return query.getResultList();
    }

    @Override
    public List<Orders> findOrdersEntities(int maxResults, int firstResult) {
        return findOrdersEntities(false, maxResults, firstResult);
    }

    private List<Orders> findOrdersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orders.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Orders findOrders(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orders.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int getOrdersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orders> rt = cq.from(Orders.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public long getLatesOrdersID() {
        List<Orders> os = findOrdersEntities();
        if (os != null && os.size() > 0) {
            Collections.reverse(os);
            Orders get = os.get(0);
            if (get != null) {
                return get.getOid();
            }
        }else{
            return 1L;
        }
        return 1L;
    }
}
