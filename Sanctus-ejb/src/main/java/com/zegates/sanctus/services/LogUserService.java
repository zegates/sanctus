package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.LogUserBeanRemote;
import com.zegates.sanctus.entity.LogUser;
import com.zegates.sanctus.services.remote.LogUserServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by sandaruwan on 8/21/16.
 */
@Stateless
@WebService(endpointInterface = "com.zegates.sanctus.services.remote.LogUserServiceRemote", serviceName = "LogUserService", targetNamespace = "http://localhost/agency/loguser")
public class LogUserService implements LogUserServiceRemote {

    @EJB//(mappedName = "LogUserBean")
    private LogUserBeanRemote logUserBean;

    @Override
    @WebMethod
    public void create(LogUser logUser) {
        logUserBean.create(logUser);
    }

    @Override @WebMethod
    public void edit(LogUser logUser) {
        logUserBean.edit(logUser);
    }

    @Override
    @WebMethod
    public void destroy(Long id) {
        logUserBean.destroy(id);
    }

    @Override
    @WebMethod public List<LogUser> findLogUserEntities() {
        return logUserBean.findLogUserEntities();
    }

    @Override
    @WebMethod
    public List<LogUser> findLogUserEntitiesLimit(int maxResults, int firstResult) {
        return findLogUserEntitiesLimit(maxResults, firstResult);
    }

    @Override
    @WebMethod
    public LogUser findLogUser(Long id) {
        return logUserBean.findLogUser(id);
    }

    @Override
    @WebMethod
    public int getLogUserCount() {
        return logUserBean.getLogUserCount();
    }
}
