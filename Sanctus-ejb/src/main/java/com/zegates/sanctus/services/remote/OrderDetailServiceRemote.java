package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.OrderDetail;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OrderDetailServiceRemote {
    @WebMethod
    void create(OrderDetail orderDetail);
    @WebMethod
    void edit(OrderDetail orderDetail);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<OrderDetail> findOrderDetailEntities();
    @WebMethod
    List<OrderDetail> findOrderDetailEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    OrderDetail findOrderDetail(Long id);
    @WebMethod
    int getOrderDetailCount();
}
