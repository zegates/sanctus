/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
public class Metric implements Serializable {

    @OneToMany(mappedBy = "metric")
    @XmlInverseReference(mappedBy="metric")
    private List<Item> items;
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mid;
    private String name;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the mid fields are not set
        if (!(object instanceof Metric)) {
            return false;
        }
        Metric other = (Metric) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.Construction[ cid=" + mid + " ]";
    }
}
