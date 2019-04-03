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
public class Kaart {

    private String naam;
    private Image afbeelding;
    private int runAwayExtra;

    public Kaart(String naam, int runAwayExtra){
        setNaam(naam);
        setRunAwayExtra(runAwayExtra);


    }
    public Kaart(String naam){
        this.naam = naam;
    }
    public Kaart() {
    }

    public void setNaam(String naam){
        this.naam = naam;
    }

    public void setRunAwayExtra(int runAwayExtra){
        this.runAwayExtra = runAwayExtra;
    }
    public String getNaam() {
        return naam;
    }

    public Image getAfbeelding(){
    return afbeelding;
    }

    public int getRunAwayExtra() {

        return runAwayExtra;
    }



}
