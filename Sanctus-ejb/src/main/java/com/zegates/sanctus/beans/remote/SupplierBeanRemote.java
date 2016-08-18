package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.Supplier;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface SupplierBeanRemote {
    void create(Supplier supplier);

    void edit(Supplier supplier);

    void destroy(Long id);

    List<Supplier> findSupplierEntities();

    List<Supplier> findSupplierEntities(int maxResults, int firstResult);

    Supplier findSupplier(Long id);

    Supplier findSupplier(String name);

    List<Supplier> findSuppliers(String queryPass, String args);

    List<Supplier> findSuppliers(String orderby);

    int getSupplierCount();
}
