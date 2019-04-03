package exceptions;

public class gespeeldeKaartNietToegelaten extends Exception {

    public gespeeldeKaartNietToegelaten() {
        super("Deze kaart mag niet gespeeld worden !");

    }


    public gespeeldeKaartNietToegelaten(String msg) {
        super(msg);
    }

    public gespeeldeKaartNietToegelaten(String message, Throwable cause){
        super(message,cause);
    }

    public gespeeldeKaartNietToegelaten(Throwable cause){
        super(cause);
    }
}
