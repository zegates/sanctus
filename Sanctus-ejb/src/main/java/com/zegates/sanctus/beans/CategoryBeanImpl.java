package com.zegates.sanctus.beans;

import com.zegates.sanctus.beans.remote.CategoryBeanRemote;
import com.zegates.sanctus.entity.Category;
import com.zegates.sanctus.remote.RemoteDBHandler;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@Stateful
public class CategoryBeanImpl implements CategoryBeanRemote {

    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }


    @Override
    public void create(Category category) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("INSERT INTO category (NAME,CID) VALUES('" + category.getName() + "','" + category.getCatid() + "')");
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Category category) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            category = em.merge(category);
            em.getTransaction().commit();
            try {
                RemoteDBHandler.setData("UPDATE category SET NAME='" + category.getName() + "' WHERE CATID='" + category.getCatid() + "' ");
            } catch (Exception e) {
                e.printStackTrace();
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
            Category category;
            category = em.getReference(Category.class, id);
            category.getCatid();
            em.remove(category);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> findConstructionEntities() {
        return findConstructionEntities(true, -1, -1);
    }

    @Override
    public List<Category> findConstructionEntities(int maxResults, int firstResult) {
        return findConstructionEntities(false, maxResults, firstResult);
    }

    private List<Category> findConstructionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Category.class));
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
    public Category findConstruction(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Category.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getConstructionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Category> rt = cq.from(Category.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Category getConstructionForName(String name) {
        String ejbql = "SELECT co from Category co WHERE co.name LIKE :pattern";
        Query query = getEntityManager().createQuery(ejbql);
        StringBuilder sb = new StringBuilder();
        sb.append("%");
        sb.append(name);
        sb.append("%");
        query.setParameter("pattern", sb.toString());
        List<Category> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
