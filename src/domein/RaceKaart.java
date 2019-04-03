/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import javafx.scene.image.Image;

/**
 *
 * @author nikol
 */
public class RaceKaart extends KerkerKaart {

    private String race;
    private String voordeel;


    public String getRace() {
        return race;
    }

    public final void setRace(String race) {
        this.race = race;
    }

    public String getVoordeel() {
        return voordeel;
    }

    public void setVoordeel(String voordeel) {
        this.voordeel = voordeel;
    }

    public RaceKaart(String naam, int runAwayExtra, String race, String voordeel) {
        super(naam, runAwayExtra);
        setRace(race);
        setVoordeel(voordeel);
    }

    @Override
    public String toString() {
        return "RaceKaart" +
                " naam = " + super.getNaam() +
                " race =  " + race  +
                " voordeel = " + voordeel + '\n'
                ;
    }
}
