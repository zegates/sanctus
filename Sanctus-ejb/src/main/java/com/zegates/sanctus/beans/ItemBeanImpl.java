package com.zegates.sanctus.beans;

import com.zegates.sanctus.beans.remote.ItemBeanRemote;
import com.zegates.sanctus.entity.Item;

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
@Stateless(mappedName = "ItemBean")
public class ItemBeanImpl implements ItemBeanRemote {


    @PersistenceContext(unitName = "zegatesagency")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public boolean  create(Item item) {
        try {
            em.persist(item);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void edit(Item item) {
        EntityManager em = null;
        try {
           em.merge(item);
            //TODO: Remote Handler Data
//            try {
//                RemoteDBHandler.setData("UPDATE item SET NAME='" + item.getName() + "', "
//                        + "CATEGORY='" + item.getCategory().toString() + "', "
//                        + "TUBETYPE='" + item.getTubeType().toString() + "', "
//                        + "CONSTRUCTION_CID='" + item.getConstruction().getMid() + "', "
//                        + "MANUFACTURER_MANUID='" + item.getManufacturer().getManuid() + "', "
//                        + "VEHICLETYPE_VID='" + item.getVehicleType().getVid() + "'"
//                        + " WHERE IID='" + item.getIid() + "'");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void destroy(Long id)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Item item = null;
            try {
                item = em.getReference(Item.class, id);
                item.getIid();
                em.remove(item);
            } catch (EntityNotFoundException enfe) {
                enfe.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Item> findItemEntities() {
        return findItemEntities(true, -1, -1);
    }

    public List<Item> findItemEntities(int maxResults, int firstResult) {
        return findItemEntities(false, maxResults, firstResult);
    }

    private List<Item> findItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Item.class));
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

    public Item findItem(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Item.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Item> rt = cq.from(Item.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }


    public Item findItemForNameAndManu(String itemName, String manufacturer) {
        String ejbql = "SELECT i from Item i WHERE i.name = :pattern AND i.manufacturer.name=:manu";
        Query query = getEntityManager().createQuery(ejbql);
        StringBuilder sb = new StringBuilder();
        //sb.append("%");
        sb.append(itemName);
//        sb.append("%");
        query.setParameter("pattern", sb.toString());
        sb = new StringBuilder();
        sb.append(manufacturer);
        query.setParameter("manu", sb.toString());
        List<Item> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

}
