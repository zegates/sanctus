/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
public class Supplier implements Serializable {

    @OneToMany(mappedBy = "supplier")
    @XmlInverseReference(mappedBy="supplier")
    private List<SupplyOrder> supplyOrders;
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long suid;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Temporal(TemporalType.TIME)
    private Date timeAdded;
    private String address;
    private String tpno;
    private String compName;
    private String email;

    public List<SupplyOrder> getSupplyOrders() {
        return supplyOrders;
    }

    public void setSupplyOrders(List<SupplyOrder> supplyOrders) {
        this.supplyOrders = supplyOrders;
    }

    public Long getSuid() {
        return suid;
    }

    public void setSuid(Long suid) {
        this.suid = suid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTpno() {
        return tpno;
    }

    public void setTpno(String tpno) {
        this.tpno = tpno;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suid != null ? suid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the suid fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.suid == null && other.suid != null) || (this.suid != null && !this.suid.equals(other.suid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.Supplier[ suid=" + suid + " ]";
    }
}
