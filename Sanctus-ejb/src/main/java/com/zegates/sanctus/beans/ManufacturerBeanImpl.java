package com.zegates.sanctus.beans;

import com.zegates.sanctus.entity.Manufacturer;
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
@Stateless//(mappedName = "ManufacturerBean")
public class ManufacturerBeanImpl implements com.zegates.sanctus.beans.remote.ManufacturerBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public void create(Manufacturer manufacturer) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(manufacturer);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("INSERT INTO manufacturer (MANUID,NAME) VALUES('" + manufacturer.getManuid() + "','" + manufacturer.getName() + "')");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(Manufacturer manufacturer){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            manufacturer = em.merge(manufacturer);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("UPDATE manufacturer SET NAME='" + manufacturer.getName() + "' WHERE"
                        + " MANUID='" + manufacturer.getManuid() + "'");
            } catch (Exception ce) {
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy(Long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Manufacturer manufacturer;
            manufacturer = em.getReference(Manufacturer.class, id);
            manufacturer.getManuid();

            em.remove(manufacturer);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Manufacturer> findManufacturerEntities() {
        return findManufacturerEntities(true, -1, -1);
    }

    public List<Manufacturer> findManufacturerEntitiesLimit(int maxResults, int firstResult) {
        return findManufacturerEntities(false, maxResults, firstResult);
    }

    private List<Manufacturer> findManufacturerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Manufacturer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Manufacturer findManufacturer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Manufacturer.class, id);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getManufacturerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Manufacturer> rt = cq.from(Manufacturer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Manufacturer findManufacturerForName(String name) {
        String ejbql = "SELECT m from Manufacturer m WHERE m.name LIKE :pattern";
        Query query = getEntityManager().createQuery(ejbql);
        StringBuilder sb = new StringBuilder();
        sb.append("%");
        sb.append(name);
        sb.append("%");
        query.setParameter("pattern", sb.toString());
        List<Manufacturer> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
