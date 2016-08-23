package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.Supplier;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SupplierServiceRemote {
    @WebMethod
    void create(Supplier supplier);
    @WebMethod
    void edit(Supplier supplier);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<Supplier> findSupplierEntities();
    @WebMethod
    List<Supplier> findSupplierEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    Supplier findSupplier(Long id);
    @WebMethod
    Supplier findSupplierForName(String name);
    @WebMethod
    List<Supplier> findSuppliers(String queryPass, String args);
    @WebMethod
    List<Supplier> findSuppliersOrder(String orderby);
    @WebMethod
    int getSupplierCount();
}
