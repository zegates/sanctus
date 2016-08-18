package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.LogUser;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface LogUserBeanRemote {
    void create(LogUser logUser);

    void edit(LogUser logUser);

    void destroy(Long id);

    List<LogUser> findLogUserEntities();

    List<LogUser> findLogUserEntities(int maxResults, int firstResult);

    LogUser findLogUser(Long id);

    int getLogUserCount();
}
