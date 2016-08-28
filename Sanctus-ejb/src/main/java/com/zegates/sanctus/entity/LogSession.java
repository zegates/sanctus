/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class LogSession implements Serializable {

    @XmlAttribute
    @XmlID	   			// should be unique across all entities.
    @Transient
    private String uuid;

    public String getUuid() {
        if(uuid == null)
            return getSeid() + "";
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @OneToMany(mappedBy = "logSession")
//    @XmlElement
//    @XmlInverseReference(mappedBy="logSession")
    private List<SupplyOrder> supplyOrders;
    @OneToMany(mappedBy = "logSession")
//    @XmlElement
//    @XmlInverseReference(mappedBy="logSession")
//    @XmlTransient
    private List<Orders> orderss;
    private static final long serialVersionUID = 1L;
    @Id
    private Long seid;

    @Temporal(TemporalType.DATE)
    private Date dateStarted;
    @Temporal(TemporalType.TIME)
    private Date timeStarted;

    public Date getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }

    public List<Orders> getOrderss() {
        return orderss;
    }

    public void setOrderss(List<Orders> orderss) {
        this.orderss = orderss;
    }
    @Temporal(TemporalType.DATE)
    private Date dateEnded;
    @Temporal(TemporalType.TIME)
    private Date timeEnded;
    private double turnOver;
    @ManyToOne
//    @XmlElement
//    @XmlInverseReference(mappedBy="logSession")
//    @XmlTransient
    @XmlIDREF
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
        this.uuid = seid + "";
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

    public Date getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Date timeEnded) {
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
