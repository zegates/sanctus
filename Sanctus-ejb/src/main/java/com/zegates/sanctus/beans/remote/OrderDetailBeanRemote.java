package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.OrderDetail;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface OrderDetailBeanRemote {
    void create(OrderDetail orderDetail);

    void edit(OrderDetail orderDetail);

    void destroy(Long id);

    List<OrderDetail> findOrderDetailEntities();

    List<OrderDetail> findOrderDetailEntities(int maxResults, int firstResult);

    OrderDetail findOrderDetail(Long id);

    int getOrderDetailCount();
}
