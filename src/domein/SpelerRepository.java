package domein;

import java.util.ArrayList;
import java.util.List;

import exceptions.spelerBestaatException;
import persistentie.SpelerMapper;

public class SpelerRepository {

    private List<Speler> spelers;
    private  SpelerMapper mapper;

    public SpelerRepository() {
        mapper = new SpelerMapper();
        haalSpelersOp();

    }

    public final void haalSpelersOp() {
            this.spelers = this.mapper.toonOverzichtSpelers();
            
            
    }

    public List<Speler> getSpelers() {
        return spelers;
    }

    public void voegSpelerToe(Speler speler) throws spelerBestaatException {
        for (int i = 0; i < spelers.size(); i++) {
           if(spelers.get(i).getNaam().toLowerCase().equals(speler.getNaam().toLowerCase())){
               throw new spelerBestaatException();
            }
        }
        spelers.add(speler);
        mapper.voegSpelerToe(speler);

    }

    public List<Speler> toonOverzichtSpelers() {
       return spelers;
    }


}
