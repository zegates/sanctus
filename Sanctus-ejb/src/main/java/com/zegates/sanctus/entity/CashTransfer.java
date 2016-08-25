/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Sandaruwan
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class CashTransfer implements Serializable {

    @XmlAttribute
    @XmlID                    // should be unique across all entities.
    @Transient
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid.toString();
    }

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ctid;
    private double amount;

    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Temporal(TemporalType.TIME)
    private Date timeAdded;

    @Enumerated(EnumType.STRING)
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
        this.uuid = ctid+"";
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }

    @Enumerated(EnumType.STRING)
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
