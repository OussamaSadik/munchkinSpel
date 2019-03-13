package test;

import exceptions.geslachtException;

import java.util.Scanner;

public class characters {

    public static void main(String[] args) {

while(true){
    Scanner x = new Scanner(System.in);
    System.out.println("Geef string in");
    String m = "man";
    String v = "vrouw";
    String y = "vrouw";
    if(!m.toLowerCase().equals(m) && !y.toLowerCase().equals(v)){
        System.out.println("fout " + y + " niet = aan " + v);
    }
    else{
        System.out.println("Juist");
    }

}

    }
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z_-]*$")));
    }
}
