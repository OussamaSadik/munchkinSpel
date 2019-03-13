package domein;

import java.util.ArrayList;
import java.util.List;

import exceptions.spelerBestaatException;
import persistentie.SpelerMapper;

public class SpelerRepository {

    private List<Speler> spelers;
    private Speler[] players; 
    private  SpelerMapper mapper;

    public final void haalSpelersOp() {
            this.spelers = this.mapper.toonOverzichtSpelers();
            
            
    }

    
    public void voegSpelerToe(Speler speler) throws spelerBestaatException {
    //    this.mapper.voegSpelerToe(speler);
        for (int i = 0; i < spelers.size(); i++) {
           if(spelers.get(i).getNaam().toLowerCase().equals(speler.getNaam().toLowerCase())){
               throw new spelerBestaatException();
            }
        }
        spelers.add(speler);
        mapper.voegSpelerToe(speler);

    }

    public void toonOverzichtSpelers() {
        for (int i = 0; i < spelers.size(); i++) {
            System.out.println(spelers.get(i));
        }
    }

    public SpelerRepository() {
        this.mapper = new SpelerMapper();
        haalSpelersOp();

    }
}
