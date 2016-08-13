/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sandaruwan
 */
@Entity
public class CashTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ctid;
    private double amount;
    private Date dateAdded;
    private Time timeAdded;
    private CashTransferType cashTransferType;
    @ManyToOne
    private LogSession logSession;

    public LogSession getLogSession() {
        return logSession;
    }

    public void setLogSession(LogSession logSession) {
        this.logSession = logSession;
    }

    public Long getCtid() {
        return ctid;
    }

    public void setCtid(Long ctid) {
        this.ctid = ctid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Time getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Time timeAdded) {
        this.timeAdded = timeAdded;
    }

    public CashTransferType getCashTransferType() {
        return cashTransferType;
    }

    public void setCashTransferType(CashTransferType cashTransferType) {
        this.cashTransferType = cashTransferType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctid != null ? ctid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ctid fields are not set
        if (!(object instanceof CashTransfer)) {
            return false;
        }
        CashTransfer other = (CashTransfer) object;
        if ((this.ctid == null && other.ctid != null) || (this.ctid != null && !this.ctid.equals(other.ctid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.CashTransfer[ ctid=" + ctid + " ]";
    }
}
