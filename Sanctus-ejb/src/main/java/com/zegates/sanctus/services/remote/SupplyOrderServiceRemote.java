package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.SupplyOrder;
import com.zegates.sanctus.entity.SupplyOrderDetail;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SupplyOrderServiceRemote {
    @WebMethod
    void create(SupplyOrder supplyOrder);
    @WebMethod
    void edit(SupplyOrder supplyOrder);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<SupplyOrder> findSupplyOrderEntities();
    @WebMethod
    List<SupplyOrder> findSupplyOrderEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    SupplyOrder findSupplyOrder(Long id);
    @WebMethod
    int getSupplyOrderCount();
    @WebMethod
    List<SupplyOrder> findSupplyOrderByColumn(String column, String keyWord);
    @WebMethod
    List<SupplyOrderDetail> findSupplyOrdersByLineId(long id);
}
