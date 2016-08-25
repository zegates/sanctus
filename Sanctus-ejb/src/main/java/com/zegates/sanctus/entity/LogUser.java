/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sandaruwan
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class LogUser implements Serializable {
//
//    public LogUser() {
//        uuid = UUID.randomUUID().toString();
//    }

    @XmlAttribute
    @XmlID	    			// should be unique across all entities.
    @Transient
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid.toString();
    }
    @OneToMany(mappedBy = "logUser",fetch = FetchType.EAGER)
    @XmlIDREF
    private List<LogSession> logSessions;

    public List<LogSession> getLogSessions() {
        return logSessions;
    }

    public void setLogSessions(List<LogSession> logSessions) {
        this.logSessions = logSessions;
    }
    private static final long serialVersionUID = 1L;
    @Id
//    @XmlTransient
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;
    private String name;
    private String address;
    private String tpno;
    private String username;
    private String pw;
    @Temporal(TemporalType.DATE)
    private Date dateAdded;
    @Temporal(TemporalType.TIME)
    private Date timeAdded;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
        this.uuid = uid + "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the uid fields are not set
        if (!(object instanceof LogUser)) {
            return false;
        }
        LogUser other = (LogUser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tireshop.persistance.entity.User[ uid=" + uid + " ]";
    }
}
