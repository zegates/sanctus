package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.SupplyOrderBeanRemote;
import com.zegates.sanctus.entity.SupplyOrder;
import com.zegates.sanctus.entity.SupplyOrderDetail;
import com.zegates.sanctus.services.remote.SupplyOrderServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.SupplyOrderServiceRemote", serviceName = "SupplyOrderService", targetNamespace = "http://localhost/agency/supplyorder")
public class SupplyOrderService implements SupplyOrderServiceRemote {

    @EJB//(mappedName = "SupplyOrderBean")
    private SupplyOrderBeanRemote supplyOrderBean;

    @Override
    @WebMethod
    public void create(SupplyOrder supplyOrder) {
        supplyOrderBean.create(supplyOrder);
    }

    @Override@WebMethod
    public void edit(SupplyOrder supplyOrder) {
        supplyOrderBean.edit(supplyOrder);
    }

    @Override@WebMethod
    public void destroy(Long id) {
        supplyOrderBean.destroy(id);
    }

    @Override@WebMethod
    public List<SupplyOrder> findSupplyOrderEntities() {
        return supplyOrderBean.findSupplyOrderEntities();
    }

    @Override@WebMethod
    public List<SupplyOrder> findSupplyOrderEntitiesLimit(int maxResults, int firstResult) {
        return supplyOrderBean.findSupplyOrderEntities(maxResults, firstResult);
    }

    @Override@WebMethod
    public SupplyOrder findSupplyOrder(Long id) {
        return supplyOrderBean.findSupplyOrder(id);
    }

    @Override@WebMethod
    public int getSupplyOrderCount() {
        return supplyOrderBean.getSupplyOrderCount();
    }

    @Override@WebMethod
    public List<SupplyOrder> findSupplyOrderByColumn(String column, String keyWord) {
        return supplyOrderBean.findSupplyOrderByColumn(column, keyWord);
    }

    @Override@WebMethod
    public List<SupplyOrderDetail> findSupplyOrdersByLineId(long id) {
        return supplyOrderBean.findSupplyOrdersByLineId(id);
    }
}
