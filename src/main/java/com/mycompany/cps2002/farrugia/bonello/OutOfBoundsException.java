
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author Farrugia, Bonello
 */
public class OutOfBoundsException extends Exception{
    
    public OutOfBoundsException(){
        System.err.println("Out of bounds error.");
    }
    
    public OutOfBoundsException(int floor, int ceiling){
        System.err.println("Only values between "+floor+" and "+ceiling+" allowed.");
    }
    
    public OutOfBoundsException(boolean isFloor, int limit){
        if(isFloor){
            System.err.println("Only values larger than "+limit+" allowed.");
        }else{
            System.err.println("Only values smaller than "+limit+" allowed.");
        }
    }
}
