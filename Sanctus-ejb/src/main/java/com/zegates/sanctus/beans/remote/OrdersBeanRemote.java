package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.Orders;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface OrdersBeanRemote {
    void create(Orders orders);

    void edit(Orders orders);

    void destroy(Long id);

    List<Orders> findOrdersEntities();

    List<Orders> findOrdersEntitiesPaidfalse(boolean paid);

    List<Orders> findOrdersEntities(int maxResults, int firstResult);

    Orders findOrders(Long id);

    int getOrdersCount();

    long getLatesOrdersID();
}
