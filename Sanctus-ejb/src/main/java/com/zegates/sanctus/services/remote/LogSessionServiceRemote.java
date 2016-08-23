package com.zegates.sanctus.services.remote;

import com.zegates.sanctus.entity.LogSession;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LogSessionServiceRemote {
    @WebMethod void create(LogSession logSession);

    @WebMethod
    void edit(LogSession logSession);

    @WebMethod void destroy(Long id);

    @WebMethod List<LogSession> findLogSessionEntities();

    @WebMethod List<LogSession> findLogSessionEntitiesLimit(int maxResults, int firstResult);

    @WebMethod LogSession findLogSession(Long id);

    @WebMethod int getLogSessionCount();
}
