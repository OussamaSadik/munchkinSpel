/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Kaart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikol
 */
public class KaartMapper {

    public void geefKaarten() {
          String a ="";
                  String b = "";
                   String c = "";
      
          
          System.out.println("De Gevonden kaarten zijn: ");
          
          

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * From ID222177_g59.Kerkerkaart");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
                 a = rs.getString("type");
                 b = rs.getString("naam");
              
         System.out.printf("Kaart is een %s met als naam %s%n", a, b);

             
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}
