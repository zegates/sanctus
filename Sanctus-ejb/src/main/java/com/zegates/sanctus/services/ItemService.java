package com.zegates.sanctus.services;

import com.zegates.sanctus.services.remote.ItemServiceRemote;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by sandaruwan on 8/13/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.ItemServiceRemote", serviceName = "ItemService", targetNamespace = "http://localhost/agency/item")//(serviceName = "ItemService", targetNamespace = "http://localhost/agency/item")
public class ItemService implements ItemServiceRemote {
    @Override
    @WebMethod(operationName = "SayHello")
    public String getHello() {
        return "Hello";
    }
}
