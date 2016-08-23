package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.SupplyOrderDetailBeanRemote;
import com.zegates.sanctus.entity.SupplyOrderDetail;
import com.zegates.sanctus.services.remote.SupplyOrderDetailServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.SupplyOrderDetailServiceRemote", serviceName = "SupplyOrderDetailService", targetNamespace = "http://localhost/agency/supplyorderdetail")
public class SupplyOrderDetailService implements SupplyOrderDetailServiceRemote {

    @EJB//(mappedName = "SupplyOrderDetailBean")
    private SupplyOrderDetailBeanRemote supplyOrderDetailBean;

    @Override@WebMethod
    public void create(SupplyOrderDetail supplyOrderDetail) {
        supplyOrderDetailBean.create(supplyOrderDetail);
    }

    @Override@WebMethod
    public void edit(SupplyOrderDetail supplyOrderDetail) {
        supplyOrderDetailBean.edit(supplyOrderDetail);
    }

    @Override@WebMethod
    public void destroy(Long id) {
        supplyOrderDetailBean.destroy(id);
    }

    @Override@WebMethod
    public List<SupplyOrderDetail> findSupplyOrderDetailEntities() {
        return supplyOrderDetailBean.findSupplyOrderDetailEntities();
    }

    @Override@WebMethod
    public List<SupplyOrderDetail> findSupplyOrderDetailEntitiesLimit(int maxResults, int firstResult) {
        return supplyOrderDetailBean.findSupplyOrderDetailEntities(maxResults, firstResult);
    }

    @Override@WebMethod
    public SupplyOrderDetail findSupplyOrderDetail(Long id) {
        return supplyOrderDetailBean.findSupplyOrderDetail(id);
    }

    @Override@WebMethod
    public int getSupplyOrderDetailCount() {
        return supplyOrderDetailBean.getSupplyOrderDetailCount();
    }

    @Override@WebMethod
    public List<SupplyOrderDetail> findSupplyOrderDetailsByItemCode(Long id) {
        return null;
    }
}
