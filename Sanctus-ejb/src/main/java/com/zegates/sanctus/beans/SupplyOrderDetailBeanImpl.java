package com.zegates.sanctus.beans;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.zegates.sanctus.entity.SupplyOrderDetail;
import com.zegates.sanctus.remote.RemoteDBHandler;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@Stateless
public class SupplyOrderDetailBeanImpl implements com.zegates.sanctus.beans.remote.SupplyOrderDetailBeanRemote {
    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(SupplyOrderDetail supplyOrderDetail) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(supplyOrderDetail);
            em.merge(supplyOrderDetail);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("INSERT INTO `supplyorderdetail` (`SODID`, `BUYINGPRICE`,"
                        + " `QTY`, `REMAININGQTY`, `SELLINGPRICE`, `ITEM_IID`, `SUPPLYORDER_SOID`)"
                        + " VALUES ('" + supplyOrderDetail.getSodid() + "', '" + supplyOrderDetail.getBuyingPrice() + "', "
                        + "'" + supplyOrderDetail.getQty() + "', '" + supplyOrderDetail.getRemainingQty() + "',"
                        + "'" + supplyOrderDetail.getSellingPrice() + "', '" + supplyOrderDetail.getItem().getIid() + "', "
                        + "'" + supplyOrderDetail.getSupplyOrder().getSoid() + "')");
            } catch (Exception ce) {
            }

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(SupplyOrderDetail supplyOrderDetail){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(supplyOrderDetail);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("UPDATE supplyorderdetail SET BUYINGPRICE='" + supplyOrderDetail.getBuyingPrice() + "'"
                        + ", QTY='" + supplyOrderDetail.getQty() + "', REMAININGQTY='" + supplyOrderDetail.getRemainingQty() + "', "
                        + "SELLINGPRICE='" + supplyOrderDetail.getSellingPrice() + "', ITEM_IID='" + supplyOrderDetail.getItem().getIid() + "',"
                        + "SUPPLYORDER_SOID='" + supplyOrderDetail.getSupplyOrder().getSoid() + "' WHERE SODID='" + supplyOrderDetail.getSodid() + "'");
            } catch (CommunicationsException ce) {
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SupplyOrderDetail supplyOrderDetail;
                supplyOrderDetail = em.getReference(SupplyOrderDetail.class, id);
                supplyOrderDetail.getSodid();

            em.remove(supplyOrderDetail);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<SupplyOrderDetail> findSupplyOrderDetailEntities() {
        return findSupplyOrderDetailEntities(true, -1, -1);
    }

    @Override
    public List<SupplyOrderDetail> findSupplyOrderDetailEntities(int maxResults, int firstResult) {
        return findSupplyOrderDetailEntities(false, maxResults, firstResult);
    }

    private List<SupplyOrderDetail> findSupplyOrderDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SupplyOrderDetail.class));
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
    public SupplyOrderDetail findSupplyOrderDetail(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SupplyOrderDetail.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getSupplyOrderDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SupplyOrderDetail> rt = cq.from(SupplyOrderDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     *
     * filter the details from supply order detail table, by specified item code
     *
     * @param id the item id to filter the supply order detail
     * @return list of supply order details filtered by the item code
     */
    @Override
    public List<SupplyOrderDetail> findSupplyOrderDetailsByItemCode(Long id) {
        EntityManager em = getEntityManager();
        try {//+" ORDER BY s.supplyOrder.dateAdded DESC"
            Query query = em.createQuery("SELECT s FROM SupplyOrderDetail s WHERE s.item.iid = " + id + " ORDER BY s.supplyOrder.dateAdded DESC");
            return query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
