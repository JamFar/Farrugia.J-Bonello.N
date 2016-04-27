
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author Farrugia, Bonello
 */
public class OutOfBoundsException extends Exception{
    
    public OutOfBoundsException(){
        System.err.println("Error: The input is unreasonable.");
    }
}
