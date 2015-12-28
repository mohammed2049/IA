import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammed
 */
public class Database {
    public static Connection Con = null;
    public static Statement Stmt = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    public Database() {
        
    }
    
    public void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Con = DriverManager.getConnection(url, user, password);
            Stmt = Con.createStatement();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
        }
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUrl(){
        return url;
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
}
