/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.utils;

import java.io.Serializable;

/**
 *
 * @author Sandaruwan
 */
public class License implements Serializable{
    
    private boolean valid=false;
    private String key=null;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public boolean getValidated(){
        if(getKey()!=null&&getKey().equals("Zega19728TireG")){
            setValid(true);
            return true;
        }
        return false;
    }
    
}
