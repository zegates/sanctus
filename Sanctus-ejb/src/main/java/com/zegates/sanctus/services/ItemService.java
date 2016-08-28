package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.ItemBeanRemote;
import com.zegates.sanctus.entity.Item;
import com.zegates.sanctus.services.remote.ItemServiceRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/13/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.ItemServiceRemote", serviceName = "ItemService", targetNamespace = "http://localhost/agency/item")
//(serviceName = "ItemService", targetNamespace = "http://localhost/agency/item")
public class ItemService implements ItemServiceRemote {

    @EJB//(mappedName = "ItemBean")
    private ItemBeanRemote itemBean;

    @PostConstruct
    private void ejbInit() {

    }

    @Override
    @WebMethod(operationName = "SayHello")
    public String getHello() {
        return "Hello";
    }

    @Override
    @WebMethod
    public boolean create(Item item) {
        return itemBean.create(item);
    }

    @Override
    @WebMethod
    public void edit(Item item) {
        itemBean.edit(item);
    }

    @Override
    @WebMethod
    public void destroy(Long id) {
        itemBean.destroy(id);
    }

    @Override
    @WebMethod
    public List<Item> findItemEntities() {
        List<Item> items = itemBean.findItemEntities();
        System.out.println("Items");
        for (Item i :items) {
            System.out.println("I " + i.getUuid());
        }

        return itemBean.findItemEntities();
    }

//    @Override
//    @WebMethod
//    public List<Item> findItemEntities(int maxResults, int firstResult) {
//        return itemBean.findItemEntities(maxResults, firstResult);
//    }

    @Override
    @WebMethod
    public Item findItem(Long id) {
        return itemBean.findItem(id);
    }

    @Override
    @WebMethod
    public int getItemCount() {
        return itemBean.getItemCount();
    }

    @Override
    @WebMethod
    public Item findItemForNameAndManu(String itemName, String manufacturer) {
        return itemBean.findItemForNameAndManu(itemName, manufacturer);
    }


}
