package exceptions;

public class geslachtException extends Exception {

    public geslachtException() {
        super("Geslacht mag enkel man of vrouw zijn !");

    }


    public geslachtException(String msg) {
        super(msg);
    }

    public geslachtException(String message, Throwable cause){
        super(message,cause);
    }

    public geslachtException(Throwable cause){
        super(cause);
    }

}
