/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zegates.sanctus.utils;

import com.zegates.sanctus.remote.RemoteServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Sandaruwan
 */
public class LReader {

    RemoteServer remoteServer = null;

    public boolean read() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("license.vbt");
        ObjectInputStream ois = new ObjectInputStream(fin);
        License l = (License) ois.readObject();
        if (l != null) {
            return l.getValidated();
        }
        return false;
    }

    public boolean isRemoteExist() {
        File f = new File("Remote.rif");
        return f.exists();
    }

    private RemoteServer readRemote() throws IOException, ClassNotFoundException {
        if (remoteServer == null) {
            FileInputStream fin = new FileInputStream("Remote.rif");
            ObjectInputStream ois = new ObjectInputStream(fin);
            remoteServer = (RemoteServer) ois.readObject();
            if (remoteServer == null) {
                throw new NullPointerException("Files are missing");
            } else {
                return remoteServer;
            }
        } else {
            return remoteServer;
        }
    }

    public String getRHOST() throws IOException, ClassNotFoundException {
        return readRemote().getrHOST();
    }

    public String getRPW() throws IOException, ClassNotFoundException {
        return readRemote().getrPW();
    }

    public String getRDB() throws IOException, ClassNotFoundException {
        return readRemote().getrDB();
    }

    public String getRUSER() throws IOException, ClassNotFoundException {
        return readRemote().getrUSER();
    }

    public String getLHOST() throws IOException, ClassNotFoundException {
        return readRemote().getlHOST();
    }

    public String getLPW() throws IOException, ClassNotFoundException {
        return readRemote().getlPW();
    }

    public String getLDB() throws IOException, ClassNotFoundException {
        return readRemote().getlDB();
    }

    public String getLUSER() throws IOException, ClassNotFoundException {
        return readRemote().getlUSER();
    }

    public String getMySqlPath() throws IOException {
        File f = new File("sqlconfig.ini");
        if (!f.exists()) {
            File file = null;
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int i = jfc.showOpenDialog(null);
            if (i == JFileChooser.APPROVE_OPTION) {
                //file = jfc.getCurrentDirectory();
                file = jfc.getSelectedFile();

                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(file.getAbsolutePath());
                bw.flush();
                bw.close();
                fw.close();
            }
        }
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            return br.readLine();
        } finally {
            br.close();
            fr.close();

        }
    }
}
