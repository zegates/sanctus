package com.zegates.sanctus.beans;

import com.zegates.sanctus.beans.remote.CashTransferBeanRemote;
import com.zegates.sanctus.entity.CashTransfer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sandaruwan on 8/14/16.
 */
@Stateless
public class CashTransferBeanImpl implements CashTransferBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public boolean create(CashTransfer cashTransfer) {
        try {
            em.persist(cashTransfer);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void edit(CashTransfer cashTransfer)  {
        EntityManager em = null;
        try {
           em.merge(cashTransfer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CashTransfer cashTransfer;
            try {
                cashTransfer = em.getReference(CashTransfer.class, id);
                cashTransfer.getCtid();
                em.remove(cashTransfer);
            } catch (EntityNotFoundException enfe) {
                enfe.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CashTransfer> findCashTransferEntities() {
        return findCashTransferEntities(true, -1, -1);
    }

    @Override
    public List<CashTransfer> findCashTransferEntities(int maxResults, int firstResult) {
        return findCashTransferEntities(false, maxResults, firstResult);
    }


    private List<CashTransfer> findCashTransferEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CashTransfer.class));
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
    public CashTransfer findCashTransfer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CashTransfer.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCashTransferCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CashTransfer> rt = cq.from(CashTransfer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return  -1;
    }
}
