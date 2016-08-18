package com.zegates.sanctus.beans.remote;

import com.zegates.sanctus.entity.LogSession;

import java.util.List;

/**
 * Created by sandaruwan on 8/18/16.
 */
public interface LogSessionBeanRemote {
    void create(LogSession logSession);

    void edit(LogSession logSession);

    void destroy(Long id);

    List<LogSession> findLogSessionEntities();

    List<LogSession> findLogSessionEntities(int maxResults, int firstResult);

    LogSession findLogSession(Long id);

    int getLogSessionCount();
}
