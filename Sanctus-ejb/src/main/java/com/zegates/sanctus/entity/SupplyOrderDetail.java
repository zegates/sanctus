/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
public class SupplyOrderDetail implements Serializable {

    @OneToMany(mappedBy = "supplyOrderDetail")
    private List<OrderDetail> orderDetails;
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sodid;
    private int qty;
    private int remainingQty;
    private double buyingPrice;
    private double sellingPrice;
    @ManyToOne
    private SupplyOrder supplyOrder;
    @ManyToOne
    private Item item;

    public int getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(int remainingQty) {
        this.remainingQty = remainingQty;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Long getSodid() {
        return sodid;
    }

    public void setSodid(Long sodid) {
        this.sodid = sodid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sodid != null ? sodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the sodid fields are not set
        if (!(object instanceof SupplyOrderDetail)) {
            return false;
        }
        SupplyOrderDetail other = (SupplyOrderDetail) object;
        if ((this.sodid == null && other.sodid != null) || (this.sodid != null && !this.sodid.equals(other.sodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.SupplyOrderDetail[ sodid=" + sodid + " ]";
    }

    public SupplyOrder getSupplyOrder() {
        return supplyOrder;
    }

    public void setSupplyOrder(SupplyOrder supplyOrder) {
        this.supplyOrder = supplyOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
