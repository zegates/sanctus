package com.zegates.sanctus.beans;

import com.zegates.sanctus.beans.remote.MetricBeanRemote;
import com.zegates.sanctus.entity.Metric;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@Stateless(mappedName = "MetricBean")
public class MetricBeanImpl implements MetricBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    @Override
    public boolean createMetric(Metric metric){
        try {
            em.persist(metric);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(Metric metric){
        try {
            em.merge(metric);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public List<Metric> findMetrics() {
        return findMetrics(true, -1, -1);
    }

    @Override
    public List<Metric> findMetrics(int maxResults, int firstResult) {
        return findMetrics(false, maxResults, firstResult);
    }

//    @Override
    @Override
    public List<Metric> findMetrics(boolean all, int maxResults, int firstResult)  {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Metric.class));
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
    public int getMetricCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Metric> rt = cq.from(Metric.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    @Override
    public long getLatesOrdersID() {
        int customerCount = getMetricCount();

        List<Metric> os = findMetrics(customerCount, customerCount - 1);
        if (os != null && os.size() > 0) {
            Collections.reverse(os);
            Metric get = os.get(0);
            if (get != null) {
                return get.getMid() + 1;
            }
        }else{
            return 1L;
        }
        return 1L;
    }

}
