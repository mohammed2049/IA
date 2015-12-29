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
     public ResultSet getAllTrips(){
        ResultSet RS = null;
        try {
            RS = Stmt.executeQuery("SELECT * FROM Trip;");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RS;
    }
    public ResultSet getTrip(String name){
        ResultSet RS = null;
        try {
            RS = Stmt.executeQuery("SELECT * FROM Trip where Name='" + name + "';");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RS;
    } 
    public void saveTrip(String name , String source , String destination , String startTime , String endTime , String price){
//        startTime = "2015-12-28 12:12";
//        endTime = "2015-12-30 01:02";
        String s = "INSERT INTO Trip\n" +
                       "(Name,\n" +
                       "Source,\n" +
                       "Destination,\n" +
                       "StartTime,\n" +
                       "EndTime,\n" +
                       "Price)\n" +
                       "VALUES\n" +
                       "('" + name + "','"+ source +"','"+ destination +"','"+ startTime +"','"+ endTime +"','"+ price +"');";
        System.out.println(s);
        
        try {
            int row = Stmt.executeUpdate(s);
            System.out.println(row);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void updateTrip(String name , String source , String destination , String startTime , String endTime , String price , String cap){
//        startTime = "2015-12-28 12:12";
//        endTime = "2015-12-30 01:02";
        String s = "UPDATE Trip SET Source=\'" + source + "\', Destination=\'" + destination + "\', StartTime=\'"+ startTime + "\', EndTime=\'" + endTime + "\', Price=\'" + price + "\', Capacity=\'" + cap +"\' WHERE Name = '" + name + "'";
        System.out.println(s);    
        try {
            int row = Stmt.executeUpdate(s);
            System.out.println(row);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
