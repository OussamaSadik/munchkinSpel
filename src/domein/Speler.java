package domein;

import exceptions.geslachtException;
import exceptions.maximaalAantalAfgelegdeKaartenBereikt;
import exceptions.playerNameException;
import exceptions.spelerBestaatException;

import java.util.ArrayList;
import java.util.List;

public class Speler {

    private String naam;
    private String geslacht;
    private int lengteNaam;
    private int niveau = 1;
    private String ras = "Mens";
    private List<Kaart> kaarten = new ArrayList<>();
    private List<Kaart> afgelegdeKaarten = new ArrayList<>();


    public Speler(String naam, String geslacht) throws geslachtException, playerNameException{

        setNaam(naam);
        setGeslacht(geslacht);
        setLengteNaam();
    }

    public String getNaam() {
        return naam;
    }

    private void setNaam(String naam) throws playerNameException {
        int maxLength = 12;
        int minLength = 6;
        if (naam.length() > maxLength || naam.length() < minLength || !isStringHowIWant(naam)) {
            throw new playerNameException();
        }
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

    public void setGeslacht(String geslacht) throws geslachtException {
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

    public int getLengteNaam() {
        return lengteNaam;
    }


    public void setLengteNaam() {

        this.lengteNaam =  this.naam.length();
    }

    public List<Kaart> getKaarten() {
        return kaarten;
    }

    public void kaartToevoegen(Kaart kaart) {

        kaarten.add(kaart);
       for (int i = 0; i < kaarten.size(); i++) {
            if(kaarten.get(i).getClass().getSimpleName().equals("RaceKaart")){
                setRas(((RaceKaart)kaarten.get(i)).getRace());
            }

            }
        }

    public int getNiveau() {
        return niveau;
    }

    public int getAantalKaarten(){
        return kaarten.size();
    }

    public void setNiveau(int niveau) {

        if(niveau < 0) this.niveau = 0;
        else this.niveau = niveau;
    }

    public void kaartVerwijderen(int index){
        kaarten.remove(index);
    }
    
    @Override
    public String toString() {
    
        return String.format("Speler met naam %s, geslacht %s, niveau %d en ras %s%n De Speler bezit %d kaarten %n", this.naam, this.geslacht, this.niveau, this.ras, getAantalKaarten());
    
    }
    public  boolean isStringHowIWant(String naam)
    {
        return ((!naam.equals(""))
                && (naam != null)
                && (naam.matches("^[a-zA-Z_-]*$")));
    }

    public List<Kaart> getAfgelegdeKaarten(){
        return afgelegdeKaarten;
    }


    public void afgelegdekaartToevoegen(Kaart kaart) throws maximaalAantalAfgelegdeKaartenBereikt {
        // Controle als kaart gespeeld mag worden
            int rasKaarten = 0;
            int headGear = 0;
            int armor = 0;
            int footgear = 0;
            int weapons = 0;


            // Afgelegde kaarten controleren
            for(int i = 0; i < afgelegdeKaarten.size(); i++){
                if(afgelegdeKaarten.get(i).getClass().getSimpleName().equals("Racekaart")){
                    rasKaarten += 1;
                }
                else if(afgelegdeKaarten.get(i).getClass().getSimpleName().equals("EquipementKaart")){
                    Kaart kaartje = afgelegdeKaarten.get(i);
                    if(((EquipmentKaart)kaartje).getSoort().toLowerCase().equals("headgear")) headGear += 1;
                    else if(((EquipmentKaart)kaartje).getSoort().toLowerCase().equals("armor")) armor += 1;
                    else if(((EquipmentKaart)kaartje).getSoort().toLowerCase().equals("footgear")) footgear += 1;
                    else if(((EquipmentKaart)kaartje).getSoort().toLowerCase().equals("weapon")) weapons += 1;
                }
            }
            // Te spelen kaart controleren
        if(kaart.getClass().getSimpleName().equals("Racekaart")) rasKaarten +=1;
        else if(kaart.getClass().getSimpleName().equals("EquipmentKaart")){
            if(((EquipmentKaart)kaart).getSoort().toLowerCase().equals("headgear")) headGear += 1;
            else if(((EquipmentKaart)kaart).getSoort().toLowerCase().equals("armor")) armor += 1;
            else if(((EquipmentKaart)kaart).getSoort().toLowerCase().equals("footgear")) footgear += 1;
            else if(((EquipmentKaart)kaart).getSoort().toLowerCase().equals("weapon")) weapons += 1;
        }

        //Validatie
        if(rasKaarten > 1 || headGear > 1 || armor > 1 || footgear > 1) throw new maximaalAantalAfgelegdeKaartenBereikt();
        if((weapons > 2 && !this.ras.toLowerCase().equals("dwarf") || this.ras.toLowerCase().equals("dwarf") && weapons > 3 ) )
            throw new maximaalAantalAfgelegdeKaartenBereikt();

        afgelegdeKaarten.add(kaart);
    }
    public void afgelegdeKaartenClearen(){
        afgelegdeKaarten.clear();
    }


}
