/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author nikol
 */
public class playerNameException extends Exception {

    /**
     * Creates a new instance of <code>playerNameException</code> without detail
     * message.
     */

    /**
     * Constructs an instance of <code>playerNameException</code> with the specified
     * detail message.
     *
     *
     */


    public playerNameException() {
        super("Lengte van de naam moet minstens 6 en maximaal 12 tekens lang zijn ! en mag enkel letters en volgende symbolen bevatten: - en _ ");

    }


    public playerNameException(String msg) {
        super(msg);
    }

    public playerNameException(String message, Throwable cause){
        super(message,cause);
    }

    public playerNameException(Throwable cause){
        super(cause);
    }
}
