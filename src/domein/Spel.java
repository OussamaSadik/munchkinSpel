package domein;

import java.util.List;

public class Spel {

    private List<KerkerKaart> kerkerKaarten;
    private List<SchatKaart> schatkaarten;
    private int aantalSpelers;

    public int getAantalSpelers() {

        return aantalSpelers;
    }

    public  void setAantalSpelers(int aantalSpelers) {

        if (aantalSpelers < 3 || aantalSpelers > 6) {
            throw new IllegalArgumentException("Het spel wordt gespeeld met minstens 3 spelers "
                    + "en maximaal 6 spelers");

        } else {
            this.aantalSpelers = aantalSpelers;

        }
    }

    public Spel(int aantalSpelers) {
        setAantalSpelers(aantalSpelers);
        KaartRepository repo = new KaartRepository();
        
    }
}
