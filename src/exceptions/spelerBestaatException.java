package exceptions;

public class spelerBestaatException  extends Exception {


    public spelerBestaatException() {
        super("De naam dat u gekozen hebt bestaat al ! ");

    }


    public spelerBestaatException(String msg) {
        super(msg);
    }

    public spelerBestaatException(String message, Throwable cause){
        super(message,cause);
    }

    public spelerBestaatException(Throwable cause){
        super(cause);
    }
}
