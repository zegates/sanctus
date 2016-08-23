package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.OrdersBeanRemote;
import com.zegates.sanctus.entity.Orders;
import com.zegates.sanctus.services.remote.OrdersServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.OrdersServiceRemote", serviceName = "OrdersService", targetNamespace = "http://localhost/agency/ordersservice")
public class OrdersService implements OrdersServiceRemote {

    @EJB//(mappedName = "OrdersBean")
    private OrdersBeanRemote ordersBean;

    @Override
    @WebMethod
    public void create(Orders orders) {
        ordersBean.create(orders);
    }

    @Override@WebMethod

    public void edit(Orders orders) {
        ordersBean.edit(orders);
    }

    @Override
    @WebMethod public void destroy(Long id) {
        ordersBean.destroy(id);
    }

    @Override
    @WebMethod
    public List<Orders> findOrdersEntities() {
        return ordersBean.findOrdersEntities();
    }

    @Override@WebMethod
    public List<Orders> findOrdersEntitiesPaidfalse(boolean paid) {
        return ordersBean.findOrdersEntitiesPaidfalse(paid);
    }

    @Override
    @WebMethod
    public List<Orders> findOrdersEntitiesLimit(int maxResults, int firstResult) {
        return ordersBean.findOrdersEntities(maxResults, firstResult);
    }

    @Override
    @WebMethod
    public Orders findOrders(Long id) {
        return ordersBean.findOrders(id);
    }

    @Override
    @WebMethod
    public int getOrdersCount() {
        return ordersBean.getOrdersCount();
    }

    @Override
    @WebMethod
    public long getLatesOrdersID() {
        return ordersBean.getLatesOrdersID();
    }
}
