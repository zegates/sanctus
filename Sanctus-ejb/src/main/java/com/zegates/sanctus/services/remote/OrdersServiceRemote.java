package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.Orders;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OrdersServiceRemote {
    @WebMethod
    void create(Orders orders);
    @WebMethod
    void edit(Orders orders);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<Orders> findOrdersEntities();
    @WebMethod
    List<Orders> findOrdersEntitiesPaidfalse(boolean paid);
    @WebMethod
    List<Orders> findOrdersEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    Orders findOrders(Long id);
    @WebMethod
    int getOrdersCount();
    @WebMethod
    long getLatesOrdersID();
}
