package domein;

import exceptions.geslachtException;
import exceptions.spelerBestaatException;

import java.util.List;

public class DomeinController {

    private Spel spel;
    SpelerRepository sp = new SpelerRepository();

    public void maakNieuwSpel(int aantalSpelers) {
        spel = new Spel(aantalSpelers);
    }

    public void registreer(String naam, String geslacht) throws spelerBestaatException, geslachtException {
       // SpelerRepository.voegSpelerToe(new Speler(naam, geslacht));
        sp.voegSpelerToe(new Speler(naam, geslacht));
    }

    public void toonOverzichtSpelers() {

      //  List<Speler> spelers = spelerRepository.toonOverzichtSpelers();
       // String[][] overzichtSpelers = new String[spelers.size()][3];

        //x
      /*  for (int i = 0; i < spelers.size(); i++) {
            Speler speler = spelers.get(i);
            overzichtSpelers[i][0] = speler.getNaam();
            overzichtSpelers[i][1] = speler.getGeslacht();
            overzichtSpelers[i][2] = "" + speler.getNiveau();
        } */
         sp.toonOverzichtSpelers();
    }

    public DomeinController() {

    }
}
