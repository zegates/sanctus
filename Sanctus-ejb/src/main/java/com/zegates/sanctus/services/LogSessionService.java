package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.LogSessionBeanRemote;
import com.zegates.sanctus.entity.LogSession;
import com.zegates.sanctus.services.remote.LogSessionServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.LogSessionServiceRemote", serviceName = "LogSessionService", targetNamespace = "http://localhost/agency/logsession")
public class LogSessionService implements LogSessionServiceRemote {

    @EJB
    LogSessionBeanRemote logSessionBean;

    @Override
    @WebMethod
    public void create(LogSession logSession) {
        logSessionBean.create(logSession);
    }

    @Override
    @WebMethod
    public void edit(LogSession logSession) {
        logSessionBean.edit(logSession);
    }

    @Override
    @WebMethod
    public void destroy(Long id) {
        logSessionBean.destroy(id);
    }

    @Override
    @WebMethod
    public List<LogSession> findLogSessionEntities() {
        return logSessionBean.findLogSessionEntities();
    }

    @Override
    @WebMethod
    public List<LogSession> findLogSessionEntitiesLimit(int maxResults, int firstResult) {
        return null;
    }

    @Override@WebMethod
    public LogSession findLogSession(Long id) {
        LogSession logSession = logSessionBean.findLogSession(id);
        logSession.setUuid(logSession.getSeid()+"");
        return logSessionBean.findLogSession(id);
    }

    @Override@WebMethod
    public int getLogSessionCount() {
        return logSessionBean.getLogSessionCount();
    }
}
