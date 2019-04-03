package exceptions;

public class aantalSpelersException extends Exception {
    public aantalSpelersException() {
        super("Het spel wordt gespeeld met minstens 3 spelers en maximaal 6 spelers !");

    }


    public aantalSpelersException(String msg) {
        super(msg);
    }

    public aantalSpelersException(String message, Throwable cause){
        super(message,cause);
    }

    public aantalSpelersException(Throwable cause){
        super(cause);
    }
}
