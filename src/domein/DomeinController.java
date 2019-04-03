package domein;

import exceptions.*;

import java.util.List;

public class DomeinController {

    private Spel spel;
    private SpelerRepository sp;

    public DomeinController() {

    }


    public void maakNieuwSpel(int aantalSpelers) throws aantalSpelersException {
        spel = new Spel(aantalSpelers);
    }

    public void registreer(String naam, String geslacht) throws spelerBestaatException, geslachtException, playerNameException {
       // SpelerRepository.voegSpelerToe(new Speler(naam, geslacht));
        Speler speler = new Speler(naam,geslacht);
        spel.voegSpelerToe(speler);
        spel.geef2BovensteKaartenVanElkeStapelaanSpeler(speler);

    }



    public List<Speler> toonOverzichtSpelers() {

    return spel.toonOverzichtSpelers();
    }

    public void bepaalVolgorde(){

           spel.bepaalVolgorde();
    }

    public Speler getWinnaar(){
       return spel.getWinnaar();
    }




    public void spelOpslaan(){

        spel.spelOpslaan();
    }

    public void spelStoppen(){
        spel.spelStoppen();
    }

    public Speler beurtVanSpeler(){
      return  spel.getCurrentPlayer();
    }

    public void volgendeSpeler(){
        spel.volgendeSpeler();
    }

    public  Kaart getBovensteKerkerKaartVanSpel(){
       return spel.haalBovensteKerkerKaart();
    }
    public void beheerKaarten(){
        spel.beheerKaarten();
    }

    public List<Speler> geefLijstVanSpelersGesorteerd(){
     return   spel.geefSpelersGesorteerdOpVolgorde();
    }

    public List<Speler> geefSpelers(){
        return spel.getSpelers();
    }

    public void verliesRas(){
        spel.spelerWordtMens();
    }
    public void veranderSex() throws geslachtException{
        spel.veranderSex();
    }
    public void verliesLevels(int levels){
        spel.verliesLevels(levels);
    }
    public void kaartVerwijderen(int i){
        spel.kaartVerwijderen(i);
    }
    public void kaartToevoegen(Kaart kaart){
        spel.kaartToevoegen(kaart);
    }
    public void steekKaartInStapel(Kaart kaart){
        spel.steekKerkerKaartInStapel(kaart);
    }

    public void setHulp(boolean hulp){
        spel.setHulp(hulp);
    }
    public void kaartInOmloopToevoegen(Kaart kaart){
        spel.kaartToevoegenAanKaartenInomloop(kaart);
    }

    public void speelKaart(Kaart kaart){
        spel.speelKaart(kaart);
    }

    public List<Speler> helpendeSpelers(){
        return spel.getHelpendeSpelers();
    }
    public boolean spelerWenstHulp(){
        return spel.WenstSpelerHulp();
    }
    public void voegHelpendeSpelerToe(Speler speler){
        spel.voegHelpendeSpelerToe(speler);
    }
    public List<Speler> geefTegenSpelers(){
        return spel.getTegenSpelers();
    }

    public void voegTegenSpelerToe(Speler speler){
        spel.voegEenTegenSpeler(speler);
    }
    public void verwijderkaartuitHanden(int index, Speler speler){
        spel.verwijderkaartuitHanden(index,speler);
    }
    public void afgelegdeKaartToevoegen(Speler speler, Kaart kaart, boolean spelerAanDeBeurt) throws maximaalAantalAfgelegdeKaartenBereikt {
        spel.afgelegdeKaartToevoegen(speler , kaart, spelerAanDeBeurt);
    }

    public Kaart geefKaartHuidigeBeurt(){
        return spel.getKaartHuidigeBeurt();
    }
    public int getGevechtsNiveauSpelerZijde() {
        return spel.getGevechtsNiveauSpelerZijde();
    }

    public int getGevechtsNiveauMonsterZijde() {
        return spel.getGevechtsNiveauMonsterZijde();
    }

}
