/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cui;

import domein.DomeinController;
import java.util.Scanner;
import exceptions.playerNameException;
import exceptions.spelerBestaatException;

/**
 *
 * @author Dsk0
 */
public class Start {
    public static void main(String[] args) {
        String naam ="";
        String geslacht = "";
        boolean fout = true;
        int counter = 0;
        Scanner invoer = new Scanner(System.in);
         DomeinController controller = new DomeinController();
         System.out.println("Geef in hoeveel spelers mee spelen:");
         int aantal = invoer.nextInt();
         controller.maakNieuwSpel(aantal);





                do{

                    try{
                        int maxLength = 12;
                        int minLength = 6;
                        System.out.printf("Geef Naam van speler %d in:%n ", counter + 1);
                        naam = invoer.next();
                        if(naam.length() > maxLength || naam.length() < minLength || !isStringOnlyAlphabet(naam) ){
                            throw new playerNameException();
                        }


                        System.out.printf("Als speler een man is geef dan M in, als speler een vrouw is geef dan V in:%n ");
                        geslacht = invoer.next();

                        controller.registreer(naam, geslacht);
                        counter +=1;
                    }
                    catch(spelerBestaatException ex){
                        System.out.println(ex +" Kies een andere naam");
                    }
                    catch(Exception e){
                        System.out.println(e + "Probeer opnieuw !");
                    }


                }
                while(counter != aantal);






        controller.toonOverzichtSpelers();


            }

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z_-]*$")));
    }




}

