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

    private final String naam;
    private final Image afbeelding;
    private final int runAwayExtra;

    public String getNaam() {
        return naam;
    }

    public Image getAfbeelding() {
        return afbeelding;
    }

    public int getRunAwayExtra() {
        return runAwayExtra;
    }

    public Kaart(String naam, Image afbeelding, int runAwayExtra) {
        this.naam = naam;
        this.afbeelding = afbeelding;
        this.runAwayExtra = runAwayExtra;
    }
    
    public void maakKaartenAan(){
        
    }
}
