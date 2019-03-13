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
    private boolean extraWapen;
    private int verkoopPrijsVerdubbeld;

    public String getRace() {
        return race;
    }

    public final void setRace(String race) {
        this.race = race;
    }

    public boolean isExtraWapen() {
        return extraWapen;
    }

    public final void setExtraWapen(boolean extraWapen) {
        this.extraWapen = extraWapen;
    }

    public int getVerkoopPrijsVerdubbeld() {
        return verkoopPrijsVerdubbeld;
    }

    public final void setVerkoopPrijsVerdubbeld(int verkoopPrijsVerdubbeld) {
        this.verkoopPrijsVerdubbeld = verkoopPrijsVerdubbeld;
    }

    public RaceKaart(String naam, Image afbeelding, int runAwayExtra, String race, boolean extraWapen, int verkoopPrijsVerdubbeld) {

        super(naam, afbeelding, runAwayExtra);
        setRace(race);
        setExtraWapen(extraWapen);
        setVerkoopPrijsVerdubbeld(verkoopPrijsVerdubbeld);
    }

}
