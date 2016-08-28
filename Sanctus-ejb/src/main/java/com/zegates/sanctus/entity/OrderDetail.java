/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 *
 * @author Sandaruwan
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDetail implements Serializable {

    @XmlAttribute
    @XmlID                    // should be unique across all entities.
    @Transient
    private String uuid;

    public String getUuid() {
        if(uuid == null)
            return getOdid() + "";
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long odid;
    private int qty;
    private double unitPrice;
    @ManyToOne
    @XmlIDREF
//    @XmlInverseReference(mappedBy="orderDetails")
    private SupplyOrderDetail supplyOrderDetail;
    @ManyToOne
    @XmlIDREF
//    @XmlInverseReference(mappedBy="orderDetails")
    private Orders order;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Long getOdid() {
        return odid;
    }

    public void setOdid(Long odid) {
        this.odid = odid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SupplyOrderDetail getSupplyOrderDetail() {
        return supplyOrderDetail;
    }

    public void setSupplyOrderDetail(SupplyOrderDetail supplyOrderDetail) {
        this.supplyOrderDetail = supplyOrderDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odid != null ? odid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the odid fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.odid == null && other.odid != null) || (this.odid != null && !this.odid.equals(other.odid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.OrderDetail[ odid=" + odid + " ]";
    }
}
