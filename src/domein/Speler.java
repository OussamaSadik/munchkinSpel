package domein;

import exceptions.geslachtException;

import java.util.List;

public class Speler {

    private String naam;
    private String geslacht;
    private int niveau = 1;
    private String ras = "Mens";
    private List<Kaart> kaarten;
    public String getNaam() {
        return naam;
    }

    private void setNaam(String naam) {


              this.naam = naam;




    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getRas(){
        return ras;
    }

    public void setRas(String ras){
        this.ras = ras;
    }
    private void setGeslacht(String geslacht) throws geslachtException {
        if(geslacht.toLowerCase().equals("m")) geslacht = "Man";
       else if(geslacht.toLowerCase().equals("v")) geslacht = "Vrouw";
        String m = "man";
        String v = "vrouw";

        if(!geslacht.toLowerCase().equals(m) && !geslacht.toLowerCase().equals(v)){
            throw new geslachtException();
        }
        else{
            this.geslacht = geslacht;
        }


    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    @Override
    public String toString() {
    
        return String.format("Speler met naam %s, geslacht %s, niveau %d en ras %s", this.naam, this.geslacht, this.niveau, this.ras);
    
    }
    public Speler(String naam, String geslacht) throws geslachtException{

        setNaam(naam);
        setGeslacht(geslacht);
    }

}
