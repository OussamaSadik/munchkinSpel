/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Speler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikol
 */
    public class SpelerMapper {
     private static final String INSERT_SPELER = "INSERT INTO ID222177_g59.speler (naam, geslacht, niveau, ras)"
                + "VALUES (?, ?, ?, ?)";
        public List<Speler> toonOverzichtSpelers() {
            List<Speler> spelers = new ArrayList<>();
            //Code

            return spelers;
        }

        public void voegSpelerToe(Speler speler) {

              try (
                    Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                    PreparedStatement query = conn.prepareStatement(INSERT_SPELER)) {
                query.setString(1, speler.getNaam());
                query.setString(2, speler.getGeslacht());
              query.setInt(3, speler.getNiveau());
                  query.setString(4, speler.getRas());

                  query.executeUpdate();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }



        public SpelerMapper() {

        }
    }
