/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.remote;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.zegates.sanctus.utils.LReader;
//import connn.ReadObject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandaruwan
 */
public class RemoteDBConnector {

    private static Connection con;
    private static RemoteDBConnector dbConnector = null;
    private static LReader lReader;
    public static String u = "tireshopdb";
    public static String h = "182.50.133.152";
    public static String p = "TireZe2224";
    public static String d = "tireshopdb";

    private RemoteDBConnector() throws SQLException, ClassNotFoundException{
//        try {
//            new DBConnectionDriver("com.mysql.jdbc.Driver", "jdbc:mysql://"+h+":3306/"+d,
//                    u, p);
//            con = DriverManager.getConnection("pool:jdbc:mysql");
//        } catch (InstantiationException ex) {
//            Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (CommunicationsException ex) {
//            Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }



        //  Class.forName("com.mysql.jdbc.Driver");
        //  con = DriverManager.getConnection("jdbc:mysql://" + h + "/" + d + "", u, p);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        try {
//                            Thread.sleep(5000);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        con = DriverManager.getConnection("jdbc:mysql://" + h + "/" + d + "", u, p);
//                    }
//                } catch (CommunicationsException ex) {
//                    Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        }).start();

        //con=DriverManager.getConnection("jdbc:mysql://"+h+"/"+d+"",u,p);
    }

    private static RemoteDBConnector getDBConnector() throws SQLException, ClassNotFoundException {
        if (dbConnector == null) {
            try {
                lReader = new LReader();
                d = lReader.getRDB();
                h = lReader.getRHOST();
                p = lReader.getRPW();
                u = lReader.getRUSER();

                // ReadObject ro = new ReadObject();
                // PW = ro.getUser().getPassword();
                //USER = ro.getUser().getUsername();
            } catch (IOException ex) {
                Logger.getLogger(RemoteDBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbConnector = new RemoteDBConnector();
        }
        return dbConnector;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection("jdbc:mysql://" + h + "/" + d + "", u, p);
    }
}
