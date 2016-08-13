/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
public class LogSession implements Serializable {

    @OneToMany(mappedBy = "logSession")
    private List<SupplyOrder> supplyOrders;
    @OneToMany(mappedBy = "logSession")
    private List<Orders> orderss;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seid;
    private Date dateStarted;
    private Time timeStarted;

    public Time getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Time timeStarted) {
        this.timeStarted = timeStarted;
    }

    public List<Orders> getOrderss() {
        return orderss;
    }

    public void setOrderss(List<Orders> orderss) {
        this.orderss = orderss;
    }
    private Date dateEnded;
    private Time timeEnded;
    private double turnOver;
    @ManyToOne
    private LogUser logUser;
    private boolean finalised;

    public List<SupplyOrder> getSupplyOrders() {
        return supplyOrders;
    }

    public void setSupplyOrders(List<SupplyOrder> supplyOrders) {
        this.supplyOrders = supplyOrders;
    }

    public boolean isFinalised() {
        return finalised;
    }

    public void setFinalised(boolean finalised) {
        this.finalised = finalised;
    }

    public LogUser getLogUser() {
        return logUser;
    }

    public void setLogUser(LogUser logUser) {
        this.logUser = logUser;
    }

    public Long getSeid() {
        return seid;
    }

    public void setSeid(Long seid) {
        this.seid = seid;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
    }

    public Time getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Time timeEnded) {
        this.timeEnded = timeEnded;
    }

    public double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(double turnOver) {
        this.turnOver = turnOver;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seid != null ? seid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the seid fields are not set
        if (!(object instanceof LogSession)) {
            return false;
        }
        LogSession other = (LogSession) object;
        if ((this.seid == null && other.seid != null) || (this.seid != null && !this.seid.equals(other.seid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.Session[ seid=" + seid + " ]";
    }
}
