package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.OrderDetailBeanRemote;
import com.zegates.sanctus.entity.OrderDetail;
import com.zegates.sanctus.services.remote.OrderDetailServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.OrderDetailServiceRemote", serviceName = "OrderDetailService", targetNamespace = "http://localhost/agency/orderdetail")
public class OrderDetailService implements OrderDetailServiceRemote {

    @EJB//(mappedName = "OrderDetailBean")
    private OrderDetailBeanRemote orderDetailBean;

    @Override
    @WebMethod
    public void create(OrderDetail orderDetail) {

    }

    @Override
    @WebMethod
    public void edit(OrderDetail orderDetail) {

    }

    @Override@WebMethod
    public void destroy(Long id) {

    }

    @Override
    @WebMethod
    public List<OrderDetail> findOrderDetailEntities() {
        return null;
    }

    @Override
    @WebMethod
    public List<OrderDetail> findOrderDetailEntitiesLimit(int maxResults, int firstResult) {
        return null;
    }

    @Override
    @WebMethod
    public OrderDetail findOrderDetail(Long id) {
        return null;
    }

    @Override
    @WebMethod
    public int getOrderDetailCount() {
        return 0;
    }
}
