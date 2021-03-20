/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapp;
import java.sql.*;

/**
 *
 * @author Captain-X
 */
public class DatabaseApp {

    
    DatabaseApp() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?zeroDateTimeBehavior=convertToNull", "root","");
            System.out.println("connected DB");
            
            Statement stmt = con.createStatement();
          
            
            
            
            
//           PreparedStatement pst1 = con.prepareStatement("insert into tab values(?,?)");
//           pst1.setInt(1, 16);
//           pst1.setString(2, "mahmoud");
//           
//           pst1.executeUpdate();
            
           
//           PreparedStatement pst2 = con.prepareStatement("update tab set name = ? where id = ?");
//           pst2.setString(1, "ahmed");
//           pst2.setInt(2, 16);
//
//           pst2.executeUpdate();

           
//           PreparedStatement pst3 = con.prepareStatement("delete from tab where id = ?");
//           
//           pst3.setInt(1, 16);
//
//           pst3.executeUpdate();

           
  

            con.setAutoCommit(false);

           PreparedStatement pst4 = con.prepareStatement("insert into tab values(?,?)");
           pst4.setInt(1, 15);
           pst4.setString(2, "Alex");
           
           pst4.addBatch();
           
           int[] up = pst4.executeBatch();
           
            //con.rollback();
            
            
            String queryString = new String("select * from tab");
             
            ResultSet rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                System.out.println(rs.getString(1)+ " " +rs.getString(2) );
            }
            
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DatabaseApp();
    }
    
}
