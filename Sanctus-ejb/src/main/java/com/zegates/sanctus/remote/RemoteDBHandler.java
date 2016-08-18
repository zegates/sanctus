/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.remote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sandaruwan
 */
public class RemoteDBHandler {

    public static int setData(String query) throws ClassNotFoundException, SQLException {
        try {
            Connection con = RemoteDBConnector.getConnection();
            Statement stm = con.createStatement();
            int result = stm.executeUpdate(query);
            return result;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public static ResultSet getdata(String query) throws SQLException, ClassNotFoundException {
        try {
            Connection con = RemoteDBConnector.getConnection();
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(query);
            return rst;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
