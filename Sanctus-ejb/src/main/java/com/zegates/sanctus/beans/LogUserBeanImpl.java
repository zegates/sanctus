package com.zegates.sanctus.beans;

import com.zegates.sanctus.entity.LogUser;
import com.zegates.sanctus.remote.RemoteDBHandler;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@Stateful
public class LogUserBeanImpl implements com.zegates.sanctus.beans.remote.LogUserBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(LogUser logUser){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(logUser);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("INSERT INTO loguser (UID, ADDRESS, DATEADDED, NAME, PW, TIMEADDED, TPNO, USERNAME) "
                        + "VALUES('" + logUser.getUid() + "', '" + logUser.getAddress() + "',"
                        + "'" + logUser.getDateAdded() + "', '" + logUser.getName() + "',"
                        + "'" + logUser.getPw() + "','" + logUser.getTimeAdded() + "',"
                        + "'" + logUser.getTpno() + "','" + logUser.getUsername() + "')");
            }catch (Exception ce) {
                ce.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(LogUser logUser){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            logUser = em.merge(logUser);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("UPDATE loguser SET ADDRESS='" + logUser.getAddress() + "', "
                        + "DATEADDED='" + logUser.getDateAdded() + "', NAME='" + logUser.getName() + "', "
                        + "PW='" + logUser.getPw() + "',TIMEADDED='" + logUser.getTimeAdded() + "', "
                        + "TPNO='" + logUser.getTpno() + "', USERNAME='" + logUser.getUsername() + "' ");
            } catch (Exception ce) {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LogUser logUser;
            logUser = em.getReference(LogUser.class, id);
            logUser.getUid();

            em.remove(logUser);
            em.getTransaction().commit();
        } catch (EntityNotFoundException enfe) {
            enfe.printStackTrace();
        }
    }

    @Override
    public List<LogUser> findLogUserEntities() {
        return findLogUserEntities(true, -1, -1);
    }

    @Override
    public List<LogUser> findLogUserEntities(int maxResults, int firstResult) {
        return findLogUserEntities(false, maxResults, firstResult);
    }

    private List<LogUser> findLogUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LogUser.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } catch (Exception e){

        }
        return  null;
    }

    @Override
    public LogUser findLogUser(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LogUser.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getLogUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LogUser> rt = cq.from(LogUser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
