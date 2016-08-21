package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.CashTransfer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.rmi.Remote;
import java.util.List;

/**
 * Created by sandaruwan on 8/13/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CashTransferServiceRemote extends Remote{

    @WebMethod
    boolean create(CashTransfer cashTransfer);
    @WebMethod
    void edit(CashTransfer cashTransfer);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<CashTransfer> findCashTransferEntities();
    @WebMethod
    List<CashTransfer> findCashTransferEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    CashTransfer findCashTransfer(Long id);
    @WebMethod
    int getCashTransferCount();
}
