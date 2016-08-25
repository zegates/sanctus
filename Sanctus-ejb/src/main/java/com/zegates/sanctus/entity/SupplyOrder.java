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
public class SupplyOrder implements Serializable {

    @OneToMany(mappedBy = "supplyOrder", cascade = CascadeType.ALL)
//    @XmlElement
//    @XmlInverseReference(mappedBy="supplyOrder")
    private List<SupplyOrderDetail> supplyOrderDetails;
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long soid;
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Temporal(TemporalType.TIME)
    private Date timeAdded;
    private double discount;
    private double total;
    @ManyToOne
//    @XmlElement
//    @XmlInverseReference(mappedBy="supplyOrders")
    private Supplier supplier;
    @ManyToOne
//    @XmlElement
//    @XmlInverseReference(mappedBy="supplyOrders")
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

    public List<SupplyOrderDetail> getSupplyOrderDetails() {
        return supplyOrderDetails;
    }

    public void setSupplyOrderDetails(List<SupplyOrderDetail> supplyOrderDetails) {
        this.supplyOrderDetails = supplyOrderDetails;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LogSession getLogSession() {
        return logSession;
    }

    public void setLogSession(LogSession logSession) {
        this.logSession = logSession;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
//        this.uuid = soid + "";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soid != null ? soid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the soid fields are not set
        if (!(object instanceof SupplyOrder)) {
            return false;
        }
        SupplyOrder other = (SupplyOrder) object;
        if ((this.soid == null && other.soid != null) || (this.soid != null && !this.soid.equals(other.soid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.SupplyOrder[ soid=" + soid + " ]";
    }
}
