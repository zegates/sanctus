/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.remote;

import java.io.Serializable;

/**
 *
 * @author Sandaruwan
 */
public class RemoteServer implements Serializable {
    private String rUSER="";
    private String rHOST="";
    private String rPW="";
    private String rDB="";
    private String lUSER="";
    private String lHOST="";
    private String lPW="";
    private String lDB="";

    public String getlUSER() {
        return lUSER;
    }

    public void setlUSER(String lUSER) {
        this.lUSER = lUSER;
    }

    public String getlHOST() {
        return lHOST;
    }

    public void setlHOST(String lHOST) {
        this.lHOST = lHOST;
    }

    public String getlPW() {
        return lPW;
    }

    public void setlPW(String lPW) {
        this.lPW = lPW;
    }

    public String getlDB() {
        return lDB;
    }

    public void setlDB(String lDB) {
        this.lDB = lDB;
    }

    public String getrUSER() {
        return rUSER;
    }

    public void setrUSER(String rUSER) {
        this.rUSER = rUSER;
    }

    public String getrHOST() {
        return rHOST;
    }

    public void setrHOST(String rHOST) {
        this.rHOST = rHOST;
    }

    public String getrPW() {
        return rPW;
    }

    public void setrPW(String rPW) {
        this.rPW = rPW;
    }

    public String getrDB() {
        return rDB;
    }

    public void setrDB(String rDB) {
        this.rDB = rDB;
    }
    
}
