package com.zegates.sanctus.containers;

import com.zegates.sanctus.entity.LogSession;
import com.zegates.sanctus.entity.LogUser;
import com.zegates.sanctus.entity.Orders;
import com.zegates.sanctus.entity.SupplyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by sandaruwan on 8/26/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EmployeeContainer")
public class LogSessionContainer {

    private LogSession logSession;
    private LogUser logUser;
    private List<Orders> orderss;
    private List<SupplyOrder> supplyOrders;

    public LogSession getLogSession() {
        return logSession;
    }

    public void setLogSession(LogSession logSession) {
        this.logSession = logSession;
        this.logUser = logSession.getLogUser();
        this.orderss = logSession.getOrderss();
        this.supplyOrders = logSession.getSupplyOrders();
    }

    public LogUser getLogUser() {
        return logUser;
    }

    public void setLogUser(LogUser logUser) {
        this.logUser = logUser;
    }

    public List<Orders> getOrderss() {
        return orderss;
    }

    public void setOrderss(List<Orders> orderss) {
        this.orderss = orderss;
    }

    public List<SupplyOrder> getSupplyOrders() {
        return supplyOrders;
    }

    public void setSupplyOrders(List<SupplyOrder> supplyOrders) {
        this.supplyOrders = supplyOrders;
    }
}
