package com.zegates.sanctus.services.remote;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.rmi.Remote;

/**
 * Created by sandaruwan on 8/13/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ItemServiceRemote extends Remote{

    @WebMethod
    String getHello();
}
