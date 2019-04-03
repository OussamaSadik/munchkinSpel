package domein;

import exceptions.aantalSpelersException;
import exceptions.geslachtException;
import exceptions.maximaalAantalAfgelegdeKaartenBereikt;
import exceptions.spelerBestaatException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spel {

    private KaartRepository kaartRepository;
    private List<KerkerKaart> kerkerKaarten;
    private List<SchatKaart> schatKaarten;
    private SpelerRepository sp;
    private List<Speler> volgordeSpelers = new ArrayList<>();
    private List<Speler> spelers = new ArrayList<>();
    private int aantalSpelers;
    private Speler winnaar;
    private Speler currentPlayer;
    private int counterSpelers = 0;
    private Kaart kaartHuidigeBeurt;
    private boolean hulp;
    private List<Kaart> kaartenInOmloop = new ArrayList<>();
    private List<Speler> helpendeSpelers = new ArrayList<>();
    private List<Speler> tegenSpelers = new ArrayList<>();
    private int gevechtsNiveauSpelerZijde = 0;
    private int gevechtsNiveauMonsterZijde = 0;



    public Spel(int aantalSpelers) throws aantalSpelersException {
        setAantalSpelers(aantalSpelers);
        kaartRepository = new KaartRepository();
        sp = new SpelerRepository();
        kerkerKaarten = kaartRepository.getKerkerKaarten();
        schatKaarten = kaartRepository.getSchatKaarten();
        Collections.shuffle(kerkerKaarten);
        Collections.shuffle(schatKaarten);

    }

    public int getAantalSpelers() {

        return aantalSpelers;
    }

    public Speler getWinnaar() {
        return winnaar;
    }

    public void setWinnaar(Speler winnaar) {
        this.winnaar = winnaar;
    }

    public  void setAantalSpelers(int aantalSpelers) throws aantalSpelersException {

        if (aantalSpelers < 3 || aantalSpelers > 6) {
            throw new aantalSpelersException();

        } else {
            this.aantalSpelers = aantalSpelers;

        }
    }




    public void geef2BovensteKaartenVanElkeStapelaanSpeler(Speler speler){
        for(int counter = 0; counter < 2; counter++){
            speler.kaartToevoegen(getBovensteKerkerKaart());
            speler.kaartToevoegen(getBovensteSchatKaart());

        }
    }

    public Kaart getBovensteKerkerKaart(){
        Kaart kaart = kerkerKaarten.get(0);
        kerkerKaarten.remove(0);

        return kaart;
    }

    public Kaart getBovensteSchatKaart(){
        Kaart kaart = schatKaarten.get(0);
        schatKaarten.remove(0);

        return kaart;
    }

    public void voegSpelerToe(Speler speler) throws spelerBestaatException {
        sp.voegSpelerToe(speler);

    }

    public List<Speler> toonOverzichtSpelers(){
      return  sp.toonOverzichtSpelers();

    }

    public void bepaalVolgorde(){
        List<Speler> spelersMem = sp.getSpelers();
        volgordeSpelers.add(bepaalEersteSpeler());
        for(int i = 0; i < spelersMem.size(); i++){
            if(spelersMem.get(i).getNaam().toLowerCase().equals(volgordeSpelers.get(0).getNaam().toLowerCase()))
                spelersMem.remove(i);
        }
        volgordeSpelers.addAll(spelersMem);
        spelers.addAll(volgordeSpelers);



    }

    public Speler bepaalEersteSpeler(){
        List<Speler> spelers = sp.getSpelers();

        Speler speler1 = spelers.get(0);
        Speler speler2;


        for(int i = 1; i < spelers.size(); i++){

                if(spelers.get(i).getLengteNaam() <= speler1.getLengteNaam()){

                    if(spelers.get(i).getLengteNaam() < speler1.getLengteNaam()){
                        speler1 = spelers.get(i);
                    }

                    else{
                      speler1 =  bepaalEersteSpelerMetOA(spelers.get(i), speler1);
                    }

                }


        }


        return speler1;

    }






    public void spelOpslaan(){

        System.out.println("Spel werdt opgeslaan");
    }

    public void spelStoppen(){

        System.out.printf("Spel wordt gestopt %n%n%n ---------Good Bye---------");
        System.exit(1);
    }





    public Speler bepaalEersteSpelerMetOA(Speler speler1, Speler speler2){
        List<String> OA = List.of("z", "y", "x","w", "v", "u", "t", "s" , "r", "q",
                "p", "o", "n", "m", "l", "k", "j", "i", "h", "g","f", "e", "d", "c"
                ,"b", "a");
        int index = 0;
        boolean running = true;
        while(running){
            char c1 =  speler1.getNaam().charAt(index);
            char c2 = speler2.getNaam().charAt(index);
            String s1 = String.valueOf(c1).toLowerCase();
            String s2 = String.valueOf(c2).toLowerCase();
            int is1 = 0;
            int is2 = 0;
            for(int i = 0; i < OA.size(); i++){
                if(s1.equals(OA.get(i))) is1 = i;
                if(s2.equals(OA.get(i))) is2 = i;

            }
            if(is1 < is2){

                running = false;
                return speler1;
            }
            else if(is1 == is2){


                index +=1;
            }
            else{
                running = false;
                return speler2;
            }
        }

        return null;
    }


    public Speler getCurrentPlayer() {
        return currentPlayer;
    }


    public void volgendeSpeler(){
        //Eerste keer dat spel een speler kiest
        if(currentPlayer == null){
            currentPlayer = volgordeSpelers.get(0);
            volgordeSpelers.remove(0);
            counterSpelers +=1;
        }
        // Spel is al bezig
        else{
            if(counterSpelers == aantalSpelers ){
                counterSpelers = 0;
                volgordeSpelers.add(currentPlayer);
                currentPlayer = volgordeSpelers.get(0);
                volgordeSpelers.remove(0);
                counterSpelers += 1;
            }
            else{
                volgordeSpelers.add(currentPlayer);
                currentPlayer = volgordeSpelers.get(0);
                volgordeSpelers.remove(0);
                counterSpelers +=1;
            }
        }

        spelers.clear();
        spelers.addAll(volgordeSpelers);
        spelers.add(currentPlayer);

        helpendeSpelers.clear();
        tegenSpelers.clear();
        afgelegdeKaartenClearen();

    }

    public List<Speler> getSpelers(){

        return spelers;
    }



    public void beheerKaarten(){
        System.out.println("Speler beheert zijn kaarten");

    }

    public Kaart haalBovensteKerkerKaart(){
        kaartHuidigeBeurt = getBovensteKerkerKaart();
       return kaartHuidigeBeurt;

    }

    public List<Speler> geefSpelersGesorteerdOpVolgorde(){
        return volgordeSpelers;
    }

    public void spelerWordtMens(){
      ;currentPlayer.setRas("Mens");
    }
    public void veranderSex() throws geslachtException{
        if(currentPlayer.getGeslacht().toLowerCase().equals("man")) currentPlayer.setGeslacht("v");
        else if(currentPlayer.getGeslacht().toLowerCase().equals("vrouw")) currentPlayer.setGeslacht("m");

    }

    public void verliesLevels(int levels){
        int currentLevel = currentPlayer.getNiveau();
        currentPlayer.setNiveau(currentLevel - levels);

    }


    public void kaartVerwijderen(int i){
        currentPlayer.kaartVerwijderen(i);
    }

    public void kaartToevoegen(Kaart kaart){
        currentPlayer.kaartToevoegen(kaart);
    }

    public void steekKerkerKaartInStapel(Kaart kaart){
        kerkerKaarten.add((KerkerKaart) kaart);
    }

    public boolean WenstSpelerHulp() {
        return hulp;
    }

    public void setHulp(boolean hulp) {
        this.hulp = hulp;
    }


    public List<Kaart> getKaartenInOmloop() {
        return kaartenInOmloop;
    }

    public void kaartToevoegenAanKaartenInomloop(Kaart kaart) {
        kaartenInOmloop.add(kaart);
    }
    public void speelKaart(Kaart kaart){
        System.out.printf("%s Kaart werd gespeeld", kaart.toString());


    }

    public List<Speler> getHelpendeSpelers() {
        return helpendeSpelers;
    }
    public void voegHelpendeSpelerToe(Speler speler){
        helpendeSpelers.add(speler);
    }

    public List<Speler> getTegenSpelers(){
        return tegenSpelers;
    }
    public void voegEenTegenSpeler(Speler speler){
        tegenSpelers.add(speler);
    }

    public void verwijderkaartuitHanden(int index, Speler speler){

        for(int i = 0; i < volgordeSpelers.size(); i++){
            if (speler.getNaam().equals(volgordeSpelers.get(i).getNaam())){
                volgordeSpelers.get(i).kaartVerwijderen(index);
            }
        }
    }

    public void afgelegdeKaartToevoegen(Speler speler, Kaart kaart, boolean spelerAanDeBeurt ) throws maximaalAantalAfgelegdeKaartenBereikt {
        if(spelerAanDeBeurt) currentPlayer.afgelegdekaartToevoegen(kaart);

        else{
            for (int e = 0; e < volgordeSpelers.size(); e++){
                if(speler.getNaam().equals(volgordeSpelers.get(e).getNaam())){
                    volgordeSpelers.get(e).afgelegdekaartToevoegen(kaart);
                }
            }
        }

    }

    public void afgelegdeKaartenClearen(){
        currentPlayer.afgelegdeKaartenClearen();

        for (int o = 0; o < volgordeSpelers.size();o++){
            volgordeSpelers.get(o).afgelegdeKaartenClearen();
        }
    }

    public Kaart getKaartHuidigeBeurt() {
        return kaartHuidigeBeurt;
    }

    public int getGevechtsNiveauSpelerZijde() {
        return gevechtsNiveauSpelerZijde;
    }

    public int getGevechtsNiveauMonsterZijde() {
        return gevechtsNiveauMonsterZijde;
    }
}



