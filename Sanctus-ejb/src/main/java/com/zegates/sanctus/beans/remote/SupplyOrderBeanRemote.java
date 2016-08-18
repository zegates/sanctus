package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.SupplyOrder;
import com.zegates.sanctus.entity.SupplyOrderDetail;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface SupplyOrderBeanRemote {
    void create(SupplyOrder supplyOrder);

    void edit(SupplyOrder supplyOrder);

    void destroy(Long id);

    List<SupplyOrder> findSupplyOrderEntities();

    List<SupplyOrder> findSupplyOrderEntities(int maxResults, int firstResult);

    SupplyOrder findSupplyOrder(Long id);

    int getSupplyOrderCount();

    List<SupplyOrder> findSupplyOrderByColumn(String column, String keyWord);

    List<SupplyOrderDetail> findSupplyOrdersByLineId(long id);
}
