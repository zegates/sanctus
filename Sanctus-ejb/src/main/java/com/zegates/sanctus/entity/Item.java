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
public class Item implements Serializable {

    @OneToMany(mappedBy = "item")
    private List<SupplyOrderDetail> supplyOrderDetails;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iid;
    private String name;
    @Enumerated(EnumType.STRING)
    private TubeType tubeType;
    @ManyToOne
    private Manufacturer manufacturer;
    @Enumerated(EnumType.STRING)
    private Category category;

    public Item() {
    }

    public Item(List<SupplyOrderDetail> supplyOrderDetails, Long iid, String name, TubeType tubeType, Manufacturer manufacturer, Category category, VehicleType vehicleType, Metric construction) {
        this.supplyOrderDetails = supplyOrderDetails;
        this.iid = iid;
        this.name = name;
        this.tubeType = tubeType;
        this.manufacturer = manufacturer;
        this.category = category;
        this.vehicleType = vehicleType;
        this.construction = construction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<SupplyOrderDetail> getSupplyOrderDetails() {
        return supplyOrderDetails;
    }

    public void setSupplyOrderDetails(List<SupplyOrderDetail> supplyOrderDetails) {
        this.supplyOrderDetails = supplyOrderDetails;
    }
    @ManyToOne
    private VehicleType vehicleType;
    @ManyToOne
    private Metric construction;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Metric getConstruction() {
        return construction;
    }

    public void setConstruction(Metric construction) {
        this.construction = construction;
    }

    public TubeType getTubeType() {
        return tubeType;
    }

    public void setTubeType(TubeType tubeType) {
        this.tubeType = tubeType;
    }

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iid != null ? iid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the iid fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.iid == null && other.iid != null) || (this.iid != null && !this.iid.equals(other.iid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.Item[ iid=" + iid + " ]";
    }
}
