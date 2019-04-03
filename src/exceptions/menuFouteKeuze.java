package exceptions;

public class menuFouteKeuze extends Exception {
    public menuFouteKeuze() {
        super("Deze optie bestaat niet !");

    }


    public menuFouteKeuze(String msg) {
        super(msg);
    }

    public menuFouteKeuze(String message, Throwable cause){
        super(message,cause);
    }

    public menuFouteKeuze(Throwable cause){
        super(cause);
    }

}
