package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.SupplierBeanRemote;
import com.zegates.sanctus.entity.Supplier;
import com.zegates.sanctus.services.remote.SupplierServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.SupplierServiceRemote", serviceName = "SupplierService", targetNamespace = "http://localhost/agency/supplierservice")
public class SupplierService implements SupplierServiceRemote {

    @EJB//(mappedName = "SupplierBean")
    private SupplierBeanRemote supplierBean;

    @Override@WebMethod
    public void create(Supplier supplier) {
        supplierBean.create(supplier);
    }

    @Override
    @WebMethod
    public void edit(Supplier supplier) {
        supplierBean.edit(supplier);
    }

    @Override
    @WebMethod
    public void destroy(Long id) {
        supplierBean.destroy(id);
    }

    @Override
    @WebMethod
    public List<Supplier> findSupplierEntities() {
        return supplierBean.findSupplierEntities();
    }

    @Override
    @WebMethod
    public List<Supplier> findSupplierEntitiesLimit(int maxResults, int firstResult) {
        return supplierBean.findSupplierEntities(maxResults, firstResult);
    }

    @Override
    @WebMethod
    public Supplier findSupplier(Long id) {
        return supplierBean.findSupplier(id);
    }

    @Override@WebMethod
    public Supplier findSupplierForName(String name) {
        return supplierBean.findSupplier(name);
    }

    @Override@WebMethod
    public List<Supplier> findSuppliers(String queryPass, String args) {
        return supplierBean.findSuppliers(queryPass, args);
    }

    @Override@WebMethod
    public List<Supplier> findSuppliersOrder(String orderby) {
        return supplierBean.findSuppliers(orderby);
    }

    @Override@WebMethod
    public int getSupplierCount() {
        return supplierBean.getSupplierCount();
    }
}
