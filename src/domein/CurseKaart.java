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
public class CurseKaart extends KerkerKaart{
    private String lose;

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public CurseKaart(String lose, String naam) {
        super(naam);
        setLose(lose);
    }

    @Override
    public String toString() {
        return "CurseKaart" +
                " naam = " + super.getNaam() +
                " lose = " + lose + '\n';
    }
}
