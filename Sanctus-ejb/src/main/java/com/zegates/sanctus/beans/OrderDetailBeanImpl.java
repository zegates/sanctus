package com.zegates.sanctus.beans;

import com.zegates.sanctus.entity.OrderDetail;

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
@Stateless//(mappedName = "OrderDetailBean")
public class OrderDetailBeanImpl implements com.zegates.sanctus.beans.remote.OrderDetailBeanRemote {
    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(OrderDetail orderDetail) {
        EntityManager em = null;
            em = getEntityManager();
            em.persist(orderDetail);
    }

    @Override
    public void edit(OrderDetail orderDetail) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            orderDetail = em.merge(orderDetail);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            OrderDetail orderDetail;
                orderDetail = em.getReference(OrderDetail.class, id);
                orderDetail.getOdid();

            em.remove(orderDetail);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<OrderDetail> findOrderDetailEntities() {
        return findOrderDetailEntities(true, -1, -1);
    }

    @Override
    public List<OrderDetail> findOrderDetailEntities(int maxResults, int firstResult) {
        return findOrderDetailEntities(false, maxResults, firstResult);
    }

    private List<OrderDetail> findOrderDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrderDetail.class));
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
    public OrderDetail findOrderDetail(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrderDetail.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int getOrderDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrderDetail> rt = cq.from(OrderDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

}
