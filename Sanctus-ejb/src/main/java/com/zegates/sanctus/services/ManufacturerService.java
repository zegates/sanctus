package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.ManufacturerBeanRemote;
import com.zegates.sanctus.entity.Manufacturer;
import com.zegates.sanctus.services.remote.ManufacturerServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.ManufacturerServiceRemote", serviceName = "ManufacturerService", targetNamespace = "http://localhost/agency/manufacturer")
public class ManufacturerService implements ManufacturerServiceRemote {

    @EJB//(mappedName = "ManufacturerBean")
    private ManufacturerBeanRemote manufacturerBean;

    @Override
    @WebMethod
    public void create(Manufacturer manufacturer) {
        manufacturerBean.create(manufacturer);
    }

    @Override
    @WebMethod
    public void edit(Manufacturer manufacturer) {
        manufacturerBean.edit(manufacturer);
    }

    @Override
    @WebMethod
    public void destroy(Long id) {
        manufacturerBean.destroy(id);
    }

    @Override
    @WebMethod
    public List<Manufacturer> findManufacturerEntities() {
        return manufacturerBean.findManufacturerEntities();
    }

    @Override
    @WebMethod
    public List<Manufacturer> findManufacturerEntitiesLimit(int maxResults, int firstResult) {
        return manufacturerBean.findManufacturerEntitiesLimit(maxResults, firstResult);
    }

    @Override
    @WebMethod
    public Manufacturer findManufacturer(Long id) {
        return manufacturerBean.findManufacturer(id);
    }

    @Override
    @WebMethod
    public int getManufacturerCount() {
        return manufacturerBean.getManufacturerCount();
    }

    @Override
    @WebMethod
    public Manufacturer findManufacturerForName(String name) {
        return manufacturerBean.findManufacturerForName(name);
    }
}
