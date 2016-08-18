package com.zegates.sanctus.beans;

import com.zegates.sanctus.beans.remote.SupplyOrderBeanRemote;
import com.zegates.sanctus.entity.*;
import com.zegates.sanctus.remote.RemoteDBHandler;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@Stateful
public class SupplyOrderBeanImpl implements SupplyOrderBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public static String LOCATION = "address";
    public static String compNAME = "compName";
    public static String NAME = "name";

    @Override
    public void create(SupplyOrder supplyOrder){
        EntityManager em = null;
        //System.out.println("Supply Order");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(supplyOrder);

            em.getTransaction().commit();
            /**
             * updates log session
             */
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplier = supplyOrder.getSupplier();
            if (supplier != null) {
                supplier = em.getReference(supplier.getClass(), supplier.getSuid());
                supplyOrder.setSupplier(supplier);
            }
            LogSession logSession = supplyOrder.getLogSession();
            if (logSession != null) {
                logSession = em.getReference(logSession.getClass(), logSession.getSeid());
                supplyOrder.setLogSession(logSession);
            }
            List<SupplyOrderDetail> attachedSupplyOrderDetails = new ArrayList<SupplyOrderDetail>();
            for (SupplyOrderDetail supplyOrderDetailsSupplyOrderDetailToAttach : supplyOrder.getSupplyOrderDetails()) {
                supplyOrderDetailsSupplyOrderDetailToAttach = em.getReference(supplyOrderDetailsSupplyOrderDetailToAttach.getClass(), supplyOrderDetailsSupplyOrderDetailToAttach.getSodid());
                attachedSupplyOrderDetails.add(supplyOrderDetailsSupplyOrderDetailToAttach);
            }
            supplyOrder.setSupplyOrderDetails(attachedSupplyOrderDetails);
            em.merge(supplyOrder);
            if (supplier != null) {
                supplier.getSupplyOrders().add(supplyOrder);
                supplier = em.merge(supplier);
            }
            if (logSession != null) {
                logSession.getSupplyOrders().add(supplyOrder);
                logSession = em.merge(logSession);
            }
            for (SupplyOrderDetail supplyOrderDetailsSupplyOrderDetail : supplyOrder.getSupplyOrderDetails()) {
                SupplyOrder oldSupplyOrderOfSupplyOrderDetailsSupplyOrderDetail = supplyOrderDetailsSupplyOrderDetail.getSupplyOrder();
                supplyOrderDetailsSupplyOrderDetail.setSupplyOrder(supplyOrder);
                supplyOrderDetailsSupplyOrderDetail = em.merge(supplyOrderDetailsSupplyOrderDetail);
                Item item = supplyOrderDetailsSupplyOrderDetail.getItem();
                item.getSupplyOrderDetails().add(supplyOrderDetailsSupplyOrderDetail);
                em.merge(item);

                if (oldSupplyOrderOfSupplyOrderDetailsSupplyOrderDetail != null) {
                    oldSupplyOrderOfSupplyOrderDetailsSupplyOrderDetail.getSupplyOrderDetails().remove(supplyOrderDetailsSupplyOrderDetail);
                    oldSupplyOrderOfSupplyOrderDetailsSupplyOrderDetail = em.merge(oldSupplyOrderOfSupplyOrderDetailsSupplyOrderDetail);
                }
            }
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("INSERT INTO `supplyorder` (`SOID`, `DATEADDED`, "
                        + "`DISCOUNT`, `TIMEADDED`, `TOTAL`, `LOGSESSION_SEID`,"
                        + " `SUPPLIER_SUID`)"
                        + "VALUES ('" + supplyOrder.getSoid() + "', '" + supplyOrder.getDateAdded() + "', "
                        + "'" + supplyOrder.getDiscount() + "', '" + supplyOrder.getTimeAdded() + "',"
                        + " '" + supplyOrder.getTotal() + "', '" + supplyOrder.getLogSession().getSeid() + "',"
                        + " '" + supplyOrder.getSupplier().getSuid() + "')");
                List<SupplyOrderDetail> supplyOrderDetails = supplyOrder.getSupplyOrderDetails();

                for (int i = 0; i < supplyOrderDetails.size(); i++) {
                    SupplyOrderDetail supplyOrderDetail = supplyOrderDetails.get(i);
                    RemoteDBHandler.setData("INSERT INTO `supplyorderdetail` (`SODID`, `BUYINGPRICE`,"
                            + " `QTY`, `REMAININGQTY`, `SELLINGPRICE`, `ITEM_IID`, `SUPPLYORDER_SOID`)"
                            + " VALUES ('" + supplyOrderDetail.getSodid() + "', '" + supplyOrderDetail.getBuyingPrice() + "', "
                            + "'" + supplyOrderDetail.getQty() + "', '" + supplyOrderDetail.getRemainingQty() + "',"
                            + "'" + supplyOrderDetail.getSellingPrice() + "', '" + supplyOrderDetail.getItem().getIid() + "', "
                            + "'" + supplyOrderDetail.getSupplyOrder().getSoid() + "')");
                }
            } catch (Exception ce) {
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(SupplyOrder supplyOrder){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(supplyOrder);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("UPDATE supplyorder SET DATEADDED='" + supplyOrder.getDateAdded() + "', "
                        + " DISCOUNT='" + supplyOrder.getDiscount() + "', TIMEADDED='" + supplyOrder.getTimeAdded() + "', "
                        + " TOTAL='" + supplyOrder.getTotal() + "', LOGSESSION_SEID='" + supplyOrder.getLogSession().getSeid() + "', "
                        + "SUPPLIER_SUID='" + supplyOrder.getSupplier().getSuid() + "' WHERE"
                        + " SOID='" + supplyOrder.getSoid() + "'");
            } catch (Exception ce) {
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SupplyOrder supplyOrder;
                supplyOrder = em.getReference(SupplyOrder.class, id);
                supplyOrder.getSoid();

            em.remove(supplyOrder);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<SupplyOrder> findSupplyOrderEntities() {
        return findSupplyOrderEntities(true, -1, -1);
    }

    @Override
    public List<SupplyOrder> findSupplyOrderEntities(int maxResults, int firstResult) {
        return findSupplyOrderEntities(false, maxResults, firstResult);
    }

    private List<SupplyOrder> findSupplyOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SupplyOrder.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SupplyOrder findSupplyOrder(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SupplyOrder.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getSupplyOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SupplyOrder> rt = cq.from(SupplyOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<SupplyOrder> findSupplyOrderByColumn(String column, String keyWord) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM SupplyOrder o WHERE o.supplier." + column + " LIKE '" + keyWord + "%'");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SupplyOrderDetail> findSupplyOrdersByLineId(long id) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM SupplyOrderDetail o WHERE o.supplyOrder.soid=" + id);
            return query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
