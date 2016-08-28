/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Manufacturer implements Serializable, Comparable<Manufacturer> {

    @XmlAttribute
    @XmlID                    // should be unique across all entities.
    @Transient
    private String uuid;

    public String getUuid() {
        if(uuid == null)
            return getManuid() + "";
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @OneToMany(mappedBy = "manufacturer")
//    @XmlInverseReference(mappedBy="manufacturer")
    private List<Item> items;
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manuid;
    private String name;

    public Long getManuid() {
        return manuid;
    }

    public void setManuid(Long manuid) {
        this.manuid = manuid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
        hash += (manuid != null ? manuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.manuid == null && other.manuid != null) || (this.manuid != null && !this.manuid.equals(other.manuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.Manufacturer[ id=" + manuid + " ]";
    }

    @Override
    public int compareTo(Manufacturer o) {
        return this.name.compareTo(o.getName());
    }
}
