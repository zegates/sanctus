/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlIDREF;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders implements Serializable {

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    @XmlInverseReference(mappedBy="order")
//    @XmlElement
    private List<OrderDetail> orderDetails;
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;
    private String custName;
    private String tpNo;
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Temporal(TemporalType.TIME)
    private Date timeAdded;
    private String address;
    private double total;
    private double discount;
    private double paidAmount;

    private boolean paid;

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public Orders(List<OrderDetail> orderDetails, Long oid, String custName, String tpNo, Date dateAdded, Date timeAdded, String address, double total, double discount, double paidAmount, LogSession logSession) {
        this.orderDetails = orderDetails;
        this.oid = oid;
        this.custName = custName;
        this.tpNo = tpNo;
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.address = address;
        this.total = total;
        this.discount = discount;
        this.paidAmount = paidAmount;
        this.logSession = logSession;
    }

    public Orders() {
    }
    @ManyToOne
//    @XmlElement
//    @XmlInverseReference(mappedBy="orderss")
    @XmlIDREF
    private LogSession logSession;
//
//    @XmlAttribute
//    @XmlID                    // should be unique across all entities.
//    @Transient
//    private String uuid;
//
//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(UUID uuid) {
//        this.uuid = uuid.toString();
//    }

    public LogSession getLogSession() {
        return logSession;
    }

    public void setLogSession(LogSession logSession) {
        this.logSession = logSession;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
//        this.uuid = oid + "";
    }


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getTpNo() {
        return tpNo;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the oid fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.Orders[ oid=" + oid + " ]";
    }
}
