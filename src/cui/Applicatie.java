/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cui;

import domein.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.Kaart;
import domein.Speler;
import exceptions.*;

/**
 *
 * @author Dsk0
 */
public class Applicatie {
    DomeinController controller = new DomeinController();

    public Applicatie() {

        String naam = "";
        String geslacht = "";
        boolean running = true;
        int counter = 0;
        int aantal = 0;
        String antw;
        int antwInt = 0;
        Scanner invoer = new Scanner(System.in);



//  Aantal Spelers geven
        do {
            try {

                System.out.println("Geef in hoeveel spelers mee spelen:");
                aantal = invoer.nextInt();

                controller.maakNieuwSpel(aantal);

                System.out.println();
                running = false;


            } catch (aantalSpelersException e) {
                System.out.println(e + " Probeer opnieuw !");
            }
            catch (InputMismatchException e){
                System.out.println( " Geef een aantal ! !");
                invoer.next();
            }

        }

        while (running);

        // Spelers registreren
        do {
            try {
                System.out.println();
                System.out.printf("Geef Naam van speler %d in:%n ", counter + 1);
                naam = invoer.next();

                System.out.printf("Als speler een man is geef dan M in, als speler een vrouw is geef dan V in:%n ");
                geslacht = invoer.next();

                controller.registreer(naam, geslacht);
                counter += 1;


            }
            catch (playerNameException e) {
                System.out.println(e + " probeer opnieuw !");
            }
            catch (spelerBestaatException ex) {
                System.out.println(ex + " Kies een andere naam");
            } catch (geslachtException e) {
                System.out.println(e + " probeer opnieuw !");
            }
        }
        while (counter != aantal);
        System.out.println();


        System.out.println();
        //Toon overzicht spelers

        for (int i = 0; i < controller.toonOverzichtSpelers().size(); i++) {
            System.out.println(controller.toonOverzichtSpelers().get(i).toString());
        }
        boolean run = true;
        do {
            try {
                //Speler wenst het spel te spelen
                System.out.print("Bent u klaar om het spel te spelen ? (geef in ja)");
                antw = invoer.next();
                if (!antw.toLowerCase().equals("ja")) throw new menuFouteKeuze();
                System.out.printf("%n%n%n Het spel begint......%n%n%n");
                run = false;
            } catch (menuFouteKeuze e) {
                System.out.println(e + " Probeer opnieuw !");
            }

        }
        while (run) ;

        // Volgorde Spel
        System.out.println();
        System.out.println();
        System.out.printf("Volgorde van het spel: %n");
        controller.bepaalVolgorde();
        for (int i = 0; i < controller.geefLijstVanSpelersGesorteerd().size(); i++) {
            String volgorde = "";
            if (i == 0) volgorde = "eerste";
            if (i == 1) volgorde = "tweede";
            if (i == 2) volgorde = "derde";
            if (i == 3) volgorde = "vierde";
            if (i == 4) volgorde = "vijfde";
            if (i == 5) volgorde = "zesde";
            System.out.printf("De %s Speler is %s%n", volgorde, controller.geefLijstVanSpelersGesorteerd().get(i).getNaam());
        }
        System.out.println();
        running = true;

        boolean nextPlayer = true;

        do {
            try {
                int keuze = 0;
                if (nextPlayer) {
                    controller.volgendeSpeler();
                }
                nextPlayer = true;
                run = true;


                do{
                    try{
                        System.out.printf("%n%nBeurt aan Speler %s%n%n", controller.beurtVanSpeler().getNaam());

                        System.out.printf("-----------Main Menu-------%n%n%n");
                        System.out.printf("Kies uit volgende opties door de nummer van het optie in te geven:%n");
                        System.out.println("1) Beurt spelen");
                        System.out.println("2) Spel opslaan");
                        System.out.println("3) Spel stopzetten");
                        System.out.print("Uw keuze: ");
                        keuze = invoer.nextInt();
                        if (keuze != 1 && keuze != 2 && keuze != 3)
                            throw new menuFouteKeuze();
                        run=false;
                    }
                    catch (menuFouteKeuze e){
                        System.out.println(e.getMessage());
                    }
                    catch (InputMismatchException e){
                        System.out.println( " Geef een aantal ! !");
                        invoer.next();
                    }

                }
                while(run);





                //Beurt spelen
                if (keuze == 1) {
                    System.out.println(controller.beurtVanSpeler().getNaam() + " speelt zijn beurt...");

                    //spel situatie
                    System.out.println();
                    System.out.println();
                    System.out.printf("Huidige spel situatie:%n%n");
                    for (int i = 0; i < controller.geefSpelers().size(); i++) {
                        System.out.printf("%s%n kaarten van de speler:%n", controller.geefSpelers().get(i).toString());
                        List<Kaart> kaartenSp = controller.geefSpelers().get(i).getKaarten();
                        for (int x = 0; x < kaartenSp.size(); x++) {
                            System.out.println(kaartenSp.get(x));
                        }
                        System.out.println();
                    }


                    System.out.println("Kerkerkaart wordt gehaald uit stapel...");
                    System.out.println("");
                    Kaart huidigeKaart = controller.getBovensteKerkerKaartVanSpel();
                    System.out.println();
                    System.out.printf("De kaart is %s%n", huidigeKaart.toString());
                    String kaartType = huidigeKaart.getClass().getSimpleName();

                    try{
                        //Bevestigen
                        boolean ok = true;
                        do{
                            try{
                                System.out.println("Als u klaar bent geef in OK");
                                antw = invoer.next();

                                if (!antw.toLowerCase().equals("ok"))
                                    throw new menuFouteKeuze();
                                ok = false;

                            }
                            catch(menuFouteKeuze e){
                                System.out.println(e);
                            }

                        }
                        while(ok);


                        //Kaart is een Monster Kaart
                        if (kaartType.equals("MonsterKaart")) {
                            int niveauMonsterZijde = 0;
                            int niveauSpelerZijde = 0;
                            //Gevecht voorbereiden

                            run = true;
                            do{
                                try{
                                    //Systeem vraagt of speler hulp nodig heeft
                                    System.out.print("Wenst u hulp van de andere spelers?(Geef J in voor Ja en N voor nee)");
                                    antw = invoer.next();
                                    if(!antw.toLowerCase().equals("j") && !antw.toLowerCase().equals("n")) throw new menuFouteKeuze();
                                    if(antw.toLowerCase().equals("j")) controller.setHulp(true);
                                    if(antw.toLowerCase().equals("n")) controller.setHulp(false);
                                    run = false;
                                }
                                catch(menuFouteKeuze e){
                                    System.out.println(e + " Probeer opnieuw");
                                }


                            }
                            while(run);



                            // Systeem vraagt of speler kaart wilt spelen // Scanner = OK
                            boolean spelerWenstNogEenKaartTeSpelen = true;
                            do {
                                try{
                                    System.out.printf("Speler : %s%n", controller.beurtVanSpeler().getNaam());

                                    System.out.println("Wenst u een kaart te spelen ?(Geef J in voor Ja en N voor nee)");
                                    antw = invoer.next();
                                    if (!antw.toLowerCase().equals("j") && !antw.toLowerCase().equals("n"))
                                        throw new menuFouteKeuze();

                                    //ja
                                    if (antw.toLowerCase().equals("j")) {
                                        System.out.println("Welke kaart wenst u te spelen ? geef de nummer van de kaart");
                                        for (int x = 0; x < controller.beurtVanSpeler().getKaarten().size(); x++) {
                                            System.out.printf("%d) %s%n", x + 1, controller.beurtVanSpeler().getKaarten().get(x));
                                        }

                                        antwInt = invoer.nextInt();
                                        if (antwInt > controller.beurtVanSpeler().getKaarten().size())
                                            throw new menuFouteKeuze();
                                        Kaart kaartInOmloop = controller.beurtVanSpeler().getKaarten().get(antwInt - 1);

                                        speelKaart(kaartInOmloop, antwInt -1, controller.beurtVanSpeler(), false, true, false);

                                        spelerWenstNogEenKaartTeSpelen = true;
                                    } else {
                                        //Spel Situatie beknopt
                                        spelerWenstNogEenKaartTeSpelen = false;
                                        System.out.printf("Te vechten Monster %s level: %d en badstuff %s%n ", huidigeKaart.getNaam(),
                                                ((MonsterKaart) huidigeKaart).getLevel() , ((MonsterKaart) huidigeKaart).getBadStuff());
                                        System.out.printf("Huidige gevechtsniveau aan spelerzijde : %d%nHuidige gevechtsniveau aan " +
                                                "Monsterzijde: %d%n", niveauSpelerZijde, niveauMonsterZijde);

                                        //Spel situatie
                                            statusSpelers();
                                        spelerWenstNogEenKaartTeSpelen = false;
                                    }

                                }
                                catch(menuFouteKeuze e){
                                    System.out.println(e + " probeer opnieuw !");
                                }
                                catch (InputMismatchException e){
                                    System.out.println( " Geef een aantal ! !");
                                    invoer.next();
                                }
                            }
                            while(spelerWenstNogEenKaartTeSpelen);

                            //-------------Tegenspelers
                            int tegenspelers = controller.geefLijstVanSpelersGesorteerd().size();
                            int counterLoop = 0;


                            for (int i = 0; i < controller.geefLijstVanSpelersGesorteerd().size(); i++) {
                                try {
                                    if (controller.spelerWenstHulp()) {
                                        run = true;
                                        do {

                                            try {
                                                System.out.printf("Tegenspeler %s, Kies tussen onderstaande acties:%n" +
                                                        "1)De speler aan de beurt helpen%n2) De speler aan de beurt tegenwerken%n" +
                                                        "3)Niets doen%n", controller.geefLijstVanSpelersGesorteerd().get(i).getNaam());
                                                antwInt = invoer.nextInt();
                                                if (antwInt != 1 && antwInt != 2 && antwInt != 3)
                                                    throw new menuFouteKeuze();
                                                run = false;
                                            } catch (menuFouteKeuze e) {
                                                System.out.println(e + " probeer opnieuw !");
                                            } catch (InputMismatchException e) {
                                                System.out.println(" Geef een aantal ! !");
                                                invoer.next();
                                            }
                                        }
                                        while (run);


                                        if (antwInt == 1) {
                                            controller.voegHelpendeSpelerToe(controller.geefLijstVanSpelersGesorteerd().get(i));
                                            run = true;
                                            do {
                                                try {
                                                    System.out.printf("%n Kies tussen onderstaande acties%n1)Helpen door kaarten te spelen%n2)Helpen zonder kaarten te spelen ");
                                                    antwInt = invoer.nextInt();
                                                    if (antwInt != 1 && antwInt != 2)
                                                        throw new menuFouteKeuze();
                                                    run = false;
                                                } catch (menuFouteKeuze e) {
                                                    System.out.println(e + " probeer opnieuw !");
                                                } catch (InputMismatchException e) {
                                                    System.out.println(" Geef een aantal ! !");
                                                    invoer.next();
                                                }
                                            }
                                            while (run);


                                            //Helpen door kaart te spelen
                                            if (antwInt == 1) {
                                                System.out.println("U hebt gekozen om de speler te helpen door een kaart te spelen");
                                                run = true;
                                                spelerWenstNogEenKaartTeSpelen = true;
                                                do {

                                                    try {
                                                        System.out.println("Wenst u een kaart te spelen ?(Geef J in voor Ja en N voor nee)");
                                                        antw = invoer.next();
                                                        if (!antw.toLowerCase().equals("j") && !antw.toLowerCase().equals("n"))
                                                            throw new menuFouteKeuze();

                                                        //ja
                                                        if (antw.toLowerCase().equals("j")) {
                                                            System.out.println("Welke kaart wenst u te spelen ? geef de nummer van de kaart");
                                                            for (int x = 0; x < controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().size(); x++) {
                                                                System.out.printf("%d) %s%n", x + 1, controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().get(x));
                                                            }
                                                            antwInt = invoer.nextInt();
                                                            if (antwInt > controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().size())
                                                                throw new menuFouteKeuze();
                                                            Kaart kaartInOmloop = controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().get(antwInt - 1);


                                                            speelKaart(kaartInOmloop, antwInt - 1, controller.geefLijstVanSpelersGesorteerd().get(i), false, false, false );


                                                            spelerWenstNogEenKaartTeSpelen = true;
                                                        } else {
                                                            //Spel Situatie beknopt
                                                            spelerWenstNogEenKaartTeSpelen = false;
                                                            System.out.printf("Te vechten Monster %s level: %d en badstuff %s%n ", huidigeKaart.getNaam(),
                                                                    ((MonsterKaart) huidigeKaart).getLevel(), ((MonsterKaart) huidigeKaart).getBadStuff());
                                                            System.out.printf("Huidige gevechtsniveau aan spelerzijde : %d%nHuidige gevechtsniveau aan " +
                                                                    "Monsterzijde: %d%n", niveauSpelerZijde, niveauMonsterZijde);

                                                                statusSpelers();
                                                            spelerWenstNogEenKaartTeSpelen = false;
                                                        }
                                                    } catch (menuFouteKeuze e) {
                                                        System.out.println(e + " probeer opnieuw !");
                                                    }
                                                }
                                                while (spelerWenstNogEenKaartTeSpelen);

                                            } else if (antwInt == 2) {


                                                /// Helpen zonder kaarten te spelen    code levels .......
                                                //Spel Situatie beknopt
                                                spelerWenstNogEenKaartTeSpelen = false;
                                                System.out.printf("Te vechten Monster %s level: %d en badstuff %s%n ", huidigeKaart.getNaam(),
                                                        ((MonsterKaart) huidigeKaart).getLevel(), ((MonsterKaart) huidigeKaart).getBadStuff());
                                                System.out.printf("Huidige gevechtsniveau aan spelerzijde : %d%nHuidige gevechtsniveau aan " +
                                                        "Monsterzijde: %d%n", niveauSpelerZijde, niveauMonsterZijde);

                                              statusSpelers();

                                            }
                                        } else if (antwInt == 2) {
                                            spelerWenstNogEenKaartTeSpelen = true;
                                            do {
                                                try {
                                                    controller.voegTegenSpelerToe(controller.geefLijstVanSpelersGesorteerd().get(i));
                                                    System.out.println("U hebt gekozen om tegen te werken");
                                                    System.out.println("Wenst u een kaart te spelen ?(Geef J in voor Ja en N voor nee)");
                                                    antw = invoer.next();

                                                    if (!antw.toLowerCase().equals("j") && !antw.toLowerCase().equals("n"))
                                                        throw new menuFouteKeuze();

                                                    //ja
                                                    if (antw.toLowerCase().equals("j")) {
                                                        System.out.println("Welke kaart wenst u te spelen ? geef de nummer van de kaart");
                                                        for (int x = 0; x < controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().size(); x++) {
                                                            System.out.printf("%d) %s%n", x + 1, controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().get(x));
                                                        }
                                                        antwInt = invoer.nextInt();
                                                        if (antwInt > controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().size())
                                                            throw new menuFouteKeuze();
                                                        Kaart kaartInOmloop = controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().get(antwInt - 1);

                                                        speelKaart(kaartInOmloop, antwInt - 1, controller.geefLijstVanSpelersGesorteerd().get(i), false,false,false);
                                                        spelerWenstNogEenKaartTeSpelen = true;
                                                    } else {
                                                        //Spel Situatie beknopt
                                                        spelerWenstNogEenKaartTeSpelen = false;
                                                        System.out.printf("Te vechten Monster %s level: %d en badstuff %s%n ", huidigeKaart.getNaam(),
                                                                ((MonsterKaart) huidigeKaart).getLevel(), ((MonsterKaart) huidigeKaart).getBadStuff());
                                                        System.out.printf("Huidige gevechtsniveau aan spelerzijde : %d%nHuidige gevechtsniveau aan " +
                                                                "Monsterzijde: %d%n", niveauSpelerZijde, niveauMonsterZijde);

                                                        //Spel situatie
                                                            statusSpelers();
                                                        spelerWenstNogEenKaartTeSpelen = false;
                                                    }
                                                } catch (menuFouteKeuze e) {
                                                    System.out.println(e + " probeer opnieuw !");
                                                }
                                            }
                                            while (spelerWenstNogEenKaartTeSpelen);
                                        } else if (antwInt == 3) {
                                            System.out.printf("U hebt gekozen om niets te doen");
                                        }
                                    }

                                    // Speler aan de beurt wenst geen hulp #scanner : OK
                                    else {
                                        run = true;
                                        do {
                                            try {
                                                System.out.printf("Tegenspeler %s, Kies tussen onderstaande acties:%n" +
                                                        "1) De speler aan de beurt tegenwerken%n" +
                                                        "2)Niets doen%n", controller.geefLijstVanSpelersGesorteerd().get(i).getNaam());
                                                antwInt = invoer.nextInt();
                                                if (antwInt != 1 && antwInt != 2) throw new menuFouteKeuze();
                                                run = false;
                                            } catch (menuFouteKeuze e) {
                                                System.out.println(e + " probeer opnieuw !");
                                            } catch (InputMismatchException e) {
                                                System.out.println(" Geef een aantal ! !");
                                                invoer.next();
                                            }
                                        }
                                        while (run);


                                        if (antwInt == 1) {
                                            controller.voegTegenSpelerToe(controller.geefLijstVanSpelersGesorteerd().get(i));
                                            run = true;
                                            spelerWenstNogEenKaartTeSpelen = true;
                                            do {
                                                try {
                                                    System.out.println("U hebt gekozen om tegen te werken");
                                                    System.out.println("Wenst u een kaart te spelen ?(Geef J in voor Ja en N voor nee)");
                                                    antw = invoer.next();

                                                    if (!antw.toLowerCase().equals("j") && !antw.toLowerCase().equals("n"))
                                                        throw new menuFouteKeuze();
                                                    run = false;
                                                    //ja
                                                    if (antw.toLowerCase().equals("j")) {
                                                        run = true;
                                                        do {
                                                            try {
                                                                System.out.println("Welke kaart wenst u te spelen ? geef de nummer van de kaart");
                                                                for (int x = 0; x < controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().size(); x++) {
                                                                    System.out.printf("%d) %s%n", x + 1, controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().get(x));
                                                                }
                                                                antwInt = invoer.nextInt();
                                                                if (antwInt > controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().size())
                                                                    throw new menuFouteKeuze();
                                                                run = false;
                                                            } catch (menuFouteKeuze e) {
                                                                System.out.println(e.getMessage());
                                                            } catch (InputMismatchException e) {
                                                                System.out.println(" Geef een aantal ! !");
                                                                invoer.next();
                                                            }
                                                        }
                                                        while (run);


                                                        Kaart kaartInOmloop = controller.geefLijstVanSpelersGesorteerd().get(i).getKaarten().get(antwInt - 1);
                                                        speelKaart(kaartInOmloop, antwInt - 1, controller.geefLijstVanSpelersGesorteerd().get(i), false, false, false);
                                                        spelerWenstNogEenKaartTeSpelen = true;
                                                    } else {
                                                        //Spel Situatie beknopt
                                                        spelerWenstNogEenKaartTeSpelen = false;
                                                        System.out.printf("Te vechten Monster %s level: %d en badstuff %s%n ", huidigeKaart.getNaam(),
                                                                ((MonsterKaart) huidigeKaart).getLevel(), ((MonsterKaart) huidigeKaart).getBadStuff());
                                                        System.out.printf("Huidige gevechtsniveau aan spelerzijde : %d%nHuidige gevechtsniveau aan " +
                                                                "Monsterzijde: %d%n", niveauSpelerZijde, niveauMonsterZijde);

                                                        statusSpelers();
                                                        spelerWenstNogEenKaartTeSpelen = false;
                                                    }
                                                } catch (menuFouteKeuze e) {
                                                    System.out.println(e + " probeer opnieuw !");
                                                } catch (InputMismatchException e) {
                                                    System.out.println(" Geef een aantal ! !");
                                                    invoer.next();
                                                }
                                            }
                                            while (spelerWenstNogEenKaartTeSpelen);
                                        } else if (antwInt == 2) {
                                            System.out.printf("U hebt gekozen om niets te doen");
                                        }


                                    }

                                    System.out.printf("%n%n%n");

                                } catch (InputMismatchException e){
                                    System.out.println( " Geef een aantal ! !");
                                    invoer.next();
                                }
                            }






                            spelerWenstNogEenKaartTeSpelen = true;
                            // Systeem vraagt of speler kaart wilt spelen
                            do{
                                try {
                                    System.out.printf("Speler : %s%n", controller.beurtVanSpeler().getNaam());
                                    System.out.println("Wenst u een kaart te spelen ?(Geef J in voor Ja en N voor nee)");
                                    antw = invoer.next();
                                    if (!antw.toLowerCase().equals("j") && !antw.toLowerCase().equals("n"))
                                        throw new menuFouteKeuze();

                                    //ja
                                    if (antw.toLowerCase().equals("j")) {
                                        System.out.println("Welke kaart wenst u te spelen ? geef de nummer van de kaart");
                                        for (int x = 0; x < controller.beurtVanSpeler().getKaarten().size(); x++) {
                                            System.out.printf("%d) %s%n", x + 1, controller.beurtVanSpeler().getKaarten().get(x));
                                        }
                                        antwInt = invoer.nextInt();
                                        if (antwInt > controller.beurtVanSpeler().getKaarten().size())
                                            throw new menuFouteKeuze();
                                        Kaart kaartInOmloop = controller.beurtVanSpeler().getKaarten().get(antwInt - 1);
                                        speelKaart(kaartInOmloop, antwInt - 1, controller.beurtVanSpeler(),false,true,true);
                                        spelerWenstNogEenKaartTeSpelen = true;
                                    }
                                    if (antw.toLowerCase().equals("n")) {
                                        spelerWenstNogEenKaartTeSpelen = false;
                                    }
                                }
                                catch(menuFouteKeuze e){
                                    System.out.println(e + " probeer opnieuw !");
                                }
                            }
                            while(spelerWenstNogEenKaartTeSpelen);

                            //Spel Situatie beknopt
                            spelerWenstNogEenKaartTeSpelen = false;
                            System.out.printf("Te vechten Monster %s level: %d en badstuff %s%n ", huidigeKaart.getNaam(),
                                    ((MonsterKaart) huidigeKaart).getLevel() , ((MonsterKaart) huidigeKaart).getBadStuff());
                            System.out.printf("Huidige gevechtsniveau aan spelerzijde : %d%nHuidige gevechtsniveau aan " +
                                    "Monsterzijde: %d%n", niveauSpelerZijde, niveauMonsterZijde);

                      statusSpelers();

                            System.out.println("Einde van de voorbereiding");
                            // Einde Voorbereiding



                            System.out.println("Speler vecht met de monster");
                            run = true;

                            do {

                                controller.beheerKaarten();
                                System.out.print("Wenst u uw kaarten opnieuw te beheren? ");
                                antw = invoer.next();
                                // Neen
                                if (antw.toLowerCase().equals("ja") || antw.toLowerCase().equals("j") || antw.toLowerCase().equals("yes")) {
                                    run = true;
                                } else {
                                    run = false;
                                }
                                if (controller.beurtVanSpeler().getAantalKaarten() > 5) {
                                    System.out.println("U hebt meer dan 5 kaarten, beheer uw kaarten opnieuw !");
                                    run = true;
                                }

                            }
                            while (run);
                        }
                        // Kaart is geen Monster Kaart
                        else {

                            // Controle als de kaart een effect heeft op de speler !
                            if (huidigeKaart.getClass().getSimpleName().equals("CurseKaart")) {
                                String lose = ((CurseKaart) huidigeKaart).getLose();
                                List<Kaart> spelerKaarten = controller.beurtVanSpeler().getKaarten();


                                // Kaart heeft een effect op de speler !

                                if (lose.toLowerCase().contains("headgear")) {
                                    boolean vanToepassing = false;
                                    for (int i = 0; i < spelerKaarten.size(); i++) {
                                        if (spelerKaarten.get(i).getClass().getSimpleName().equals("EquipmentKaart")) {
                                            EquipmentKaart kaart = (EquipmentKaart) spelerKaarten.get(i);
                                            if (kaart.getSoort().toLowerCase().equals("headgear")) {
                                                System.out.println("Speler is een kaart verloren : %s " + spelerKaarten.get(i).toString());
                                                controller.kaartVerwijderen(i);
                                                System.out.println("");
                                                vanToepassing = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!vanToepassing) System.out.println("Speler heeft geen Headgear");
                                } else if (lose.toLowerCase().contains("footgear")) {
                                    boolean vanToepassing = false;
                                    for (int i = 0; i < spelerKaarten.size(); i++) {
                                        if (spelerKaarten.get(i).getClass().getSimpleName().equals("EquipmentKaart")) {
                                            EquipmentKaart kaart = (EquipmentKaart) spelerKaarten.get(i);
                                            if (kaart.getSoort().toLowerCase().equals("footgear")) {
                                                System.out.println("Speler is een kaart verloren : %s" + spelerKaarten.get(i).toString());
                                                controller.kaartVerwijderen(i);
                                                System.out.println();
                                                break;
                                            }
                                        }
                                    }
                                    if (!vanToepassing) System.out.println("Speler heeft geen footgear");
                                }
                                else if (lose.toLowerCase().contains("race")) {
                                    boolean vanToepassing = false;
                                    for (int i = 0; i < spelerKaarten.size(); i++) {
                                        if (spelerKaarten.get(i).getClass().getSimpleName().equals("RaceKaart")) {
                                            controller.verliesRas();
                                            controller.kaartVerwijderen(i);
                                            System.out.println("Speler wordt een mens");
                                            System.out.println();
                                            vanToepassing = true;
                                            break;
                                        }
                                    }
                                    if (!vanToepassing) System.out.println("Speler is al een mens");
                                } else if (lose.toLowerCase().contains("sex")) {
                                    controller.veranderSex();
                                    System.out.println("Sex van de speler is verandert");
                                } else if (lose.toLowerCase().contains("2 levels")) {
                                    controller.verliesLevels(2);
                                    System.out.println(controller.beurtVanSpeler() + " Verliest 2 levels");

                                }  else if (lose.toLowerCase().contains("level")) {
                                    controller.verliesLevels(1);
                                    System.out.println(controller.beurtVanSpeler().getNaam() + " Verliest 1 level");
                                } else if (lose.toLowerCase().contains("armor")) {
                                    boolean vanToepassing = false;
                                    for (int i = 0; i < spelerKaarten.size(); i++) {
                                        if (spelerKaarten.get(i).getClass().getSimpleName().equals("EquipmentKaart")) {
                                            EquipmentKaart kaart = (EquipmentKaart) spelerKaarten.get(i);
                                            if (kaart.getSoort().toLowerCase().equals("armor")) {
                                                System.out.println("Speler verliest zijn armor");

                                                controller.kaartVerwijderen(i);

                                            }
                                        }
                                    }
                                    if (!vanToepassing) System.out.println("Speler heeft geen Armor");
                                }else if (lose.toLowerCase().contains("item")) {
                                    boolean beschiktMinstents1Item = false;
                                    List<EquipmentKaart> items = new ArrayList<>();
                                    for (int i = 0; i < spelerKaarten.size(); i++) {
                                        if (spelerKaarten.get(i).getClass().getSimpleName().equals("EquipmentKaart")) {
                                            beschiktMinstents1Item = true;
                                            items.add((EquipmentKaart) spelerKaarten.get(i));

                                        }

                                    }
                                    if (beschiktMinstents1Item) {
                                        System.out.println("Je verliest 1 Item");
                                        System.out.println("Kies welke item je verliest door de nummer van de kaart in te geven : ");
                                        for (int i = 0; i < items.size(); i++) {
                                            System.out.printf("%d) %s%n", i + 1, items.get(i));
                                        }

                                        antwInt = invoer.nextInt();
                                        if (antwInt > items.size() || antwInt < 1) throw new menuFouteKeuze();
                                        else {
                                            int foundedItems = 0;
                                            for (int x = 0; x < controller.beurtVanSpeler().getKaarten().size(); x++) {
                                                if (controller.beurtVanSpeler().getKaarten().get(x).getClass().getSimpleName().equals("EquipmentKaart")) {
                                                    foundedItems += 1;
                                                    if (antwInt == foundedItems)
                                                        controller.kaartVerwijderen(x);
                                                }

                                            }
                                        }
                                    } else {
                                        System.out.println("Speler heeft geen item kaart niet van toepassing");
                                    }
                                }

                                controller.steekKaartInStapel(huidigeKaart);

                            }
                            /// geen effect op speler
                            else {
                                controller.kaartToevoegen(huidigeKaart);
                                System.out.println("Kaart heeft geen effect op de speler, deze wordt toegevoegd aan de kaarten van de speler");
                            }

                            run = true;
                            do {
                                controller.beheerKaarten();
                                System.out.print("Wenst u uw kaarten opnieuw te beheren? ");
                                antw = invoer.next();
                                // Neen
                                if (antw.toLowerCase().equals("ja") || antw.toLowerCase().equals("j") || antw.toLowerCase().equals("yes")) {
                                    run = true;
                                }
                                else{
                                    run = false;
                                }
                                if (controller.beurtVanSpeler().getAantalKaarten() > 5) {
                                    System.out.println("U hebt meer dan 5 kaarten, beheer uw kaarten opnieuw !");
                                    run = true;
                                }
                            }
                            while (run);

                        }
                        //spel situatie
                        System.out.println();
                        System.out.println();
                        System.out.println("Huidige spel situatie:");
                        for (int i = 0; i < controller.geefSpelers().size(); i++) {
                            System.out.printf("%s%n kaarten van de speler:%n", controller.geefSpelers().get(i).toString());
                            List<Kaart> kaartenSp = controller.geefSpelers().get(i).getKaarten();
                            for (int x = 0; x < kaartenSp.size(); x++) {
                                System.out.println(kaartenSp.get(x));
                            }
                            System.out.println();
                        }

                    }
                    catch(menuFouteKeuze e){
                        System.out.println(e + " Try again!");
                    }



                }
                if (keuze == 2) {
                    controller.spelOpslaan();
                    nextPlayer = false;
                }
                if (keuze == 3) controller.spelStoppen();

                if (controller.getWinnaar() != null) running = false;

            } catch (geslachtException e) {
                System.out.println(e + " probeer opnieuw !");
            }

            catch (InputMismatchException e){
                System.out.println( " Geef een aantal ! !");
                invoer.next();
            }


        }  while (running);
        System.out.printf("%n%n De Winnaar is   %s%d", controller.getWinnaar().getNaam(), controller.getWinnaar().getNiveau());
    }


        public void speelKaart(Kaart kaart, int index, Speler speler, boolean spelerLooptWeg, boolean spelerAanDeBeurt, boolean medespelersAlGevraagd){
          try{
              System.out.printf("U hebt kaart %s gekozen%n", kaart.toString());


              String kaartType = kaart.getClass().getSimpleName();
              String kaartSoort =  kaart.getClass().getSuperclass().getSimpleName();

              //loopt niet Weg
              if(!spelerLooptWeg){
                    //Speler aan de beurt
                  if(spelerAanDeBeurt){
                      if(!kaartType.equals("EquipmentKaart") && !kaartType.equals("ConsumableKaart")
                              && !kaartType.equals("SchatConsumableKaart") && !kaartType.equals("RaceKaart")
                              && !kaartType.equals("MonsterKaart")){
                          throw new gespeeldeKaartNietToegelaten();

                      }
                      //Kaart type gevalideert
                      else{
                                if(kaartType.equals("MonsterKaart") && medespelersAlGevraagd) throw new gespeeldeKaartNietToegelaten();
                                controller.afgelegdeKaartToevoegen(speler, kaart,spelerAanDeBeurt);
                          controller.kaartVerwijderen(index);
                          controller.kaartInOmloopToevoegen(kaart);


                      }

                  }
                  //Tegenspelers
                  else {
                      if( !kaartType.equals("ConsumableKaart")
                              && !kaartType.equals("SchatConsumableKaart") && !kaartType.equals("CurseKaart")
                              && !kaartType.equals("MonsterKaart"))
                          throw new gespeeldeKaartNietToegelaten();

                          //Kaart type gevalideert
                      else{
                            // Speler wenst geen hulp
                          if(!controller.spelerWenstHulp()){
                              if(kaart.getClass().getSimpleName().equals("ConsumableKaart")) {
                                  if(kaart.getNaam().toLowerCase().equals("baby")) throw new gespeeldeKaartNietToegelaten("U kunt enkel negatieve kaarten spelen");
                              }

                          }
                          //speler wenst hulp
                          else{
                              controller.afgelegdeKaartToevoegen(speler, kaart,spelerAanDeBeurt);
                              controller.verwijderkaartuitHanden(index,speler);
                              controller.kaartInOmloopToevoegen(kaart);
                          }

                      }


                  }
              }
              //Speler loopt weg
              else{
                  System.out.println("De speler aan de beurt mag geen kaarten afleggen terwijl hij weg loopt");
              }


            //Spelsituatie

              //Te vechten monster
              System.out.println(controller.geefKaartHuidigeBeurt().toString());

              //Gevechtsniveau
              System.out.println("Gevechts niveau aan Speler zijde: " + controller.getGevechtsNiveauSpelerZijde());
              System.out.println("Gevechts niveau aan Monster zijde: " + controller.getGevechtsNiveauMonsterZijde());

                //Status Spelers
                  statusSpelers();
              //afgelgde kaarten
              System.out.printf("Afgelegde kaarten van %s%n",speler.getNaam());
              for (int i = 0; i < speler.getAfgelegdeKaarten().size(); i++){
                  System.out.println(speler.getAfgelegdeKaarten().get(i));
              }


          }
        catch(gespeeldeKaartNietToegelaten e){
            System.out.println(e.getMessage());
        } catch (exceptions.maximaalAantalAfgelegdeKaartenBereikt maximaalAantalAfgelegdeKaartenBereikt) {
              System.out.println(maximaalAantalAfgelegdeKaartenBereikt.getMessage());
          }

        }

        public void statusSpelers(){
            //Spel situatie
            System.out.println();
            System.out.println();
            System.out.printf("Huidige spel situatie:%n%n");
            for (int i = 0; i < controller.geefSpelers().size(); i++) {
                Speler speler = controller.geefSpelers().get(i);
                String status = "Status : doet niets";
                //controleer de helpende spelers
                for (int x = 0; x < controller.helpendeSpelers().size(); x++) {
                    if (speler.getNaam().equals(controller.helpendeSpelers().get(x).getNaam())) {
                        status = "Status : Helpt de speler aan de beurt.";
                    }
                }
                // controleert de tegenspelers
                for (int x = 0; x < controller.geefTegenSpelers().size(); x++) {
                    if (speler.getNaam().equals(controller.geefTegenSpelers().get(x).getNaam())) {
                        status = "Status : Speelt tegen.";
                    }
                }
                if (speler.getNaam().equals(controller.beurtVanSpeler().getNaam()))
                    status = "Status : Speler aan de beurt";
                System.out.printf("Speler: %s level = %s en geslacht %s : %s%n", speler.getNaam(),speler.getNiveau(),
                        speler.getGeslacht(), status);

                System.out.println();
            }
        }
}

