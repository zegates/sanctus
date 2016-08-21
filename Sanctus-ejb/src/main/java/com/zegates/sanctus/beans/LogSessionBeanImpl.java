package com.zegates.sanctus.beans;

import com.zegates.sanctus.entity.LogSession;
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
public class LogSessionBeanImpl implements com.zegates.sanctus.beans.remote.LogSessionBeanRemote {
    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(LogSession logSession){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.persist(logSession);

            try {
                RemoteDBHandler.setData("INSERT INTO logsession (SEID, DATESTARTED, "
                        + "FINALISED, TIMESTARTED, LOGUSER_UID) VALUES("
                        + "'" + logSession.getSeid() + "','" + logSession.getDateStarted() + "',"
                        + "'" + (logSession.isFinalised() ? 1 : 0) + "', "
                        + "'" + logSession.getTimeStarted() + "','" + logSession.getLogUser().getUid() + "')");
            } catch (Exception ce) {
                ce.printStackTrace();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void edit(LogSession logSession) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            logSession = em.merge(logSession);

            try {
                RemoteDBHandler.setData("UPDATE logsession SET DATEENDED='" + logSession.getDateEnded() + "',"
                        + " DATESTARTED='" + logSession.getDateStarted() + "', "
                        + " FINALISED='" + (logSession.isFinalised() ? 1 : 0) + "', "
                        + " TIMEENDED='" + logSession.getTimeEnded() + "', "
                        + " TIMESTARTED='" + logSession.getTimeStarted() + "',"
                        + " TURNOVER='" + logSession.getTurnOver() + "',"
                        + " LOGUSER_UID='" + logSession.getLogUser().getUid() + "' WHERE SEID='" + logSession.getSeid() + "' ");
            } catch (Exception ce) {
                ce.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LogSession logSession;
                logSession = em.getReference(LogSession.class, id);
                logSession.getSeid();

            em.remove(logSession);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<LogSession> findLogSessionEntities() {
        return findLogSessionEntities(true, -1, -1);
    }

    @Override
    public List<LogSession> findLogSessionEntities(int maxResults, int firstResult) {
        return findLogSessionEntities(false, maxResults, firstResult);
    }

    private List<LogSession> findLogSessionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LogSession.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public LogSession findLogSession(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LogSession.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getLogSessionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LogSession> rt = cq.from(LogSession.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
