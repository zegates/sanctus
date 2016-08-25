package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.containers.LogUserContainer;
import com.zegates.sanctus.entity.LogUser;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LogUserServiceRemote {
    @WebMethod
    void create(LogUser logUser);
    @WebMethod
    void edit(LogUser logUser);
    @WebMethod
    void destroy(Long id);
    @WebMethod
    List<LogUser> findLogUserEntities();
    @WebMethod
    List<LogUser> findLogUserEntitiesLimit(int maxResults, int firstResult);
    @WebMethod
    LogUserContainer findLogUser(Long id);
    @WebMethod
    int getLogUserCount();
}
