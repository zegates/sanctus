package com.zegates.sanctus.containers;

import com.zegates.sanctus.entity.LogSession;
import com.zegates.sanctus.entity.LogUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by sandaruwan on 8/25/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EmployeeContainer")
public class LogUserContainer {

    private LogUser logUser;

    private List<LogSession> logSessions;

    public LogUser getLogUser() {
        return logUser;
    }

    public void setLogUser(LogUser logUser) {
        this.logUser = logUser;
        this.logSessions = logUser.getLogSessions();
    }

    public List<LogSession> getLogSessions() {
        return logSessions;
    }

    public void setLogSessions(List<LogSession> logSessions) {
        this.logSessions = logSessions;
    }
}
