package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.CashTransferBeanRemote;
import com.zegates.sanctus.entity.CashTransfer;
import com.zegates.sanctus.services.remote.CashTransferServiceRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.CashTransferServiceRemote", serviceName = "CashTransferService", targetNamespace = "http://localhost/agency/cashtransfer")
public class CashTransferService implements CashTransferServiceRemote{

    @EJB
    private CashTransferBeanRemote cashTransferBean;

    @Override
    @WebMethod
    public boolean create(CashTransfer cashTransfer) {
        return cashTransferBean.create(cashTransfer);
    }

    @Override
    @WebMethod
    public void edit(CashTransfer cashTransfer) {
        cashTransferBean.edit(cashTransfer);

    }

    @Override
    @WebMethod
    public void destroy(Long id) {
        cashTransferBean.destroy(id);
    }

    @Override
    @WebMethod
    public List<CashTransfer> findCashTransferEntities() {
        return cashTransferBean.findCashTransferEntities();
    }

    @Override
    @WebMethod
    public List<CashTransfer> findCashTransferEntitiesLimit(int maxResults, int firstResult) {
        return cashTransferBean.findCashTransferEntities(maxResults,firstResult);
    }

    @Override
    @WebMethod
    public CashTransfer findCashTransfer(Long id) {
        return cashTransferBean.findCashTransfer(id);
    }

    @Override
    @WebMethod
    public int getCashTransferCount() {
        return cashTransferBean.getCashTransferCount();
    }
}
