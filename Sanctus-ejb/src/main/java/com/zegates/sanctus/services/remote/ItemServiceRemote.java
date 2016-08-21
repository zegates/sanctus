package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.Item;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.rmi.Remote;
import java.util.List;

/**
 * Created by sandaruwan on 8/13/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ItemServiceRemote extends Remote{

    @WebMethod
    String getHello();
    @WebMethod
    public boolean create(Item item);
    @WebMethod
    public void edit(Item item);
    @WebMethod
    public void destroy(Long id);
    @WebMethod
    List<Item> findItemEntities();
//    @WebMethod
//    List<Item> findItemEntities(int maxResults, int firstResult);
    @WebMethod
    Item findItem(Long id);
    @WebMethod
    int getItemCount();
    @WebMethod
    Item findItemForNameAndManu(String itemName, String manufacturer);
}
