/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.KaartMapper;
import persistentie.SpelerMapper;

/**
 *
 * @author nikol
 */
public class KaartRepository {

  // private List<Kaart> kaarten;
    private String kaarten;
   

     public KaartRepository() {
     haalKaartenOp();
    }  
    public void haalKaartenOp() {
       KaartMapper x = new KaartMapper();
         x.geefKaarten();
    }
    public String toonKaarten() {

        return this.kaarten;
    }
   
}
