package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.Manufacturer;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface ManufacturerBeanRemote {

    void create(Manufacturer manufacturer);

    void edit(Manufacturer manufacturer);

    void destroy(Long id);

    List<Manufacturer> findManufacturerEntities();

    List<Manufacturer> findManufacturerEntitiesLimit(int maxResults, int firstResult);

    Manufacturer findManufacturer(Long id);

    int getManufacturerCount() ;

    Manufacturer findManufacturerForName(String name);

}
