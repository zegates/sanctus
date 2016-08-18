package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.SupplyOrderDetail;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface SupplyOrderDetailBeanRemote {
    void create(SupplyOrderDetail supplyOrderDetail);

    void edit(SupplyOrderDetail supplyOrderDetail);

    void destroy(Long id);

    List<SupplyOrderDetail> findSupplyOrderDetailEntities();

    List<SupplyOrderDetail> findSupplyOrderDetailEntities(int maxResults, int firstResult);

    SupplyOrderDetail findSupplyOrderDetail(Long id);

    int getSupplyOrderDetailCount();

    List<SupplyOrderDetail> findSupplyOrderDetailsByItemCode(Long id);
}
