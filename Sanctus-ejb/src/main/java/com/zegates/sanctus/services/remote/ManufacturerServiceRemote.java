package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.Manufacturer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ManufacturerServiceRemote {
    @WebMethod
    void create(Manufacturer manufacturer);
    @WebMethod
    void edit(Manufacturer manufacturer);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<Manufacturer> findManufacturerEntities();
    @WebMethod
    List<Manufacturer> findManufacturerEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    Manufacturer findManufacturer(Long id);
    @WebMethod
    int getManufacturerCount() ;
    @WebMethod
    Manufacturer findManufacturerForName(String name);

}
