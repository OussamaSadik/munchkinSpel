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

     private List<Kaart> kaarten = new ArrayList<>();
     private List<KerkerKaart> kerkerKaarten = new ArrayList<>();
     private List<SchatKaart> schatKaarten = new ArrayList<>();
     public KaartMapper kaartMapper;

     public KaartRepository() {
         kaartMapper = new KaartMapper();
         maakKaarten();
         System.out.printf("%d kaarten werden geinitialiseerd %n%d schatkaarten en %d kerkerkaarten", kaarten.size()
         , schatKaarten.size(), kerkerKaarten.size());


     }


    public void maakKaarten() {

        kerkerKaarten = kaartMapper.haalKerkerKaartenUitDB();
        kaarten.addAll(kerkerKaarten);

        schatKaarten = kaartMapper.haalSchatKaartenUitDB();
        kaarten.addAll(schatKaarten);
    }


    public List<KerkerKaart> getKerkerKaarten(){
         return kerkerKaarten;
    }

    public List<SchatKaart> getSchatKaarten() {
        return schatKaarten;
    }
}
