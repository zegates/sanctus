package com.zegates.sanctus.services;

import com.zegates.sanctus.beans.remote.LogUserBeanRemote;
import com.zegates.sanctus.containers.LogUserContainer;
import com.zegates.sanctus.entity.LogSession;
import com.zegates.sanctus.entity.LogUser;
import com.zegates.sanctus.services.remote.LogUserServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.UUID;

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
        List<LogUser> logUsers = logUserBean.findLogUserEntities();
        System.out.println("Find Users "+logUsers.toString());
        for (LogUser logUser:logUsers) {
            logUser.setUuid(UUID.randomUUID().toString());
            System.out.println("Log User : "+logUser.getUuid());
            List<LogSession> logSessions = logUser.getLogSessions();
            for (LogSession s : logSessions) {
//                s.setLogUser(null);
                s.setUuid(UUID.randomUUID().toString());
                System.out.println("Log Session "+ s.getSeid()+" "+s.getUuid());
            }
        }


        return logUsers;
    }

    @Override
    @WebMethod
    public List<LogUser> findLogUserEntitiesLimit(int maxResults, int firstResult) {
        return findLogUserEntitiesLimit(maxResults, firstResult);
    }

    @Override
    @WebMethod
    public LogUserContainer findLogUser(Long id) {
        LogUser logUser = logUserBean.findLogUser(id);
        logUser.setUuid(logUser.getUid()+"");
        System.out.println("Log User : "+logUser.getUuid());
        List<LogSession> logSessions = logUser.getLogSessions();
        for (LogSession s : logSessions) {
//                s.setLogUser(null);
            s.setUuid(s.getSeid()+"");
            System.out.println("Log Session "+ s.getSeid()+" "+s.getUuid());
        }
//        List<LogSession> logSessions = logUser.getLogSessions();
//        for (LogSession s:
//             logSessions) {
//            s.setLogUser(null);
//        }

        LogUserContainer lc = new LogUserContainer();
        lc.setLogUser(logUser);
        return lc;
    }

    @Override
    @WebMethod
    public int getLogUserCount() {
        return logUserBean.getLogUserCount();
    }
}
