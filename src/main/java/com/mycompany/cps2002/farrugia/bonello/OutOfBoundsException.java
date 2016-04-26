/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author James
 */
public class OutOfBoundsException extends Exception{
    
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
