/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.*;

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

    // int idKaart = 0;
    private List<Kaart> kaarten;
    private List<KerkerKaart> kerkerkaarten = new ArrayList<>();
    private List<SchatKaart> schatKaarten = new ArrayList<>();

    String type = "";
    int treasuresRewards = 0;
    int runAwayExtra = 0;
    int level = 0;
    int levelsRewards = 0;
    String race = "";
    String naam = "";
    String badStuff = "";
    boolean extraWapen = false;
    String extraWapenVW = "";
    int extraLevel = 0;
    String extraLevelVW = "";
    int verlorenLevelsBijRunAway = 0;
    int runAwayVanafLevel = 1;
    String lose = "";
    String voordeel = "";

    public KaartMapper() {
    }

    public List<KerkerKaart> haalKerkerKaartenUitDB() {

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * From ID222177_g59.Kerkerkaart");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
             //   idKaart = rs.getInt("idKerkerkaart");

                if(rs.getString("type") != null || rs.getString("type").equals("") )
                 type = rs.getString("type");


                 treasuresRewards = rs.getInt("treasuresRewards");

                 runAwayExtra = rs.getInt("runAwayExtra");
                 level = rs.getInt("level");
                 levelsRewards = rs.getInt("levelsRewards");
                 if(rs.getString("race") != null  )
                 race = rs.getString("race");


                 if(rs.getString("naam") != null)
                 naam = rs.getString("naam");

                 if(rs.getString("badStuff") != null)
                 badStuff = rs.getString("badStuff");

                 voordeel = rs.getString("voordeel");
                    extraLevel = rs.getInt("extraLevel");


                 if(rs.getString("extraLevelVW") != null)
                 extraLevelVW = rs.getString("extraLevelVW");

                 verlorenLevelsBijRunAway = rs.getInt("verlorenLevelsBijRunAway");
                 runAwayVanafLevel = rs.getInt("runAwayVanafLevel");

                 if(rs.getString("lose") != null)
                 lose = rs.getString("lose");

                if(type.equals("Consumable")){
                    kerkerkaarten.add(new ConsumableKaart(extraLevel,extraLevelVW,naam));
                }
                else if(type.equals("Race")){
                    kerkerkaarten.add(new RaceKaart(naam, runAwayExtra, race, voordeel));
                }
                else if(type.equals("Monster")) kerkerkaarten.add(new MonsterKaart(naam, runAwayExtra, badStuff, extraLevel, extraLevelVW, level, levelsRewards, runAwayVanafLevel, treasuresRewards, verlorenLevelsBijRunAway));

                else if(type.equals("Curse"))    kerkerkaarten.add(new CurseKaart(lose, naam));
             }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return kerkerkaarten;
    }


    public List<SchatKaart> haalSchatKaartenUitDB() {

        String type = "";
        int bonus = 0;
        String extraBonusVW = "";
        int extraBonus = 0;
        int waardeVerkoop = 0;
        String soort = "";
        boolean bonusVoorBeideKanten = false;
        String instantKillMonster = "";
        int freeLevels = 0;
        String kanGebruiktWordenDoor = "";
        String naam = "";
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
             PreparedStatement query = conn.prepareStatement("SELECT * From ID222177_g59.Schatkaart");
             ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
                //   idKaart = rs.getInt("idSchatkaart");

                    type = rs.getString("type");
                    bonus = rs.getInt("bonus");
                    extraBonusVW = rs.getString("extraBonusVW");
                    extraBonus = rs.getInt("extraBonus");
                    waardeVerkoop = rs.getInt("waardeVerkoop");
                    soort = rs.getString("soort");
                    bonusVoorBeideKanten = rs.getBoolean("bonusVoorBeideKanten");
                    instantKillMonster = rs.getString("instantKillMonster");
                    freeLevels = rs.getInt("freeLevels");
                    kanGebruiktWordenDoor = rs.getString("kanGebruiktWordenDoor");
                    naam = rs.getString("naam");
                if(type.equals("Consumable")){
                    schatKaarten.add(new SchatConsumableKaart(naam,  bonus, bonusVoorBeideKanten, instantKillMonster, freeLevels, waardeVerkoop));

                }
                else if(type.equals("Equipment")){
                    schatKaarten.add(new EquipmentKaart(soort, kanGebruiktWordenDoor, extraBonusVW, extraBonus , bonus, naam, waardeVerkoop));

                }
                 }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return schatKaarten;
    }


    }
