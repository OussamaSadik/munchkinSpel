package test;

import test.ConnectieTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dsk0
 */
public class testClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
          // List<Kaart> kaarten = new ArrayList<>();
         String a ="";
                  String b = "";
                   String c = "";
      
          
          System.out.println("in de mapper klasse");
          
          

        try (Connection conn = DriverManager.getConnection(ConnectieTest.JDBC_URL);
             PreparedStatement query = conn.prepareStatement("SELECT * From Kerkerkaart");
             ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
                 a = rs.getString("type");
                 b = rs.getString("naam");
              

             
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        System.out.printf("Kaart is een %s met als naam %s%n", a, b);
    }
   
}
