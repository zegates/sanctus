package com.zegates.sanctus.services.remote;

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
public interface SupplyOrderDetailServiceRemote {
    @WebMethod
    void create(SupplyOrderDetail supplyOrderDetail);
    @WebMethod
    void edit(SupplyOrderDetail supplyOrderDetail);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<SupplyOrderDetail> findSupplyOrderDetailEntities();
    @WebMethod
    List<SupplyOrderDetail> findSupplyOrderDetailEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    SupplyOrderDetail findSupplyOrderDetail(Long id);
    @WebMethod
    int getSupplyOrderDetailCount();
    @WebMethod
    List<SupplyOrderDetail> findSupplyOrderDetailsByItemCode(Long id);
}
