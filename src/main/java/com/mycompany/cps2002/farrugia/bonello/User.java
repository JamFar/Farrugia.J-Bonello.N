
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author Farrugia, Bonello
 */
public class User {
    
    final private int idNum;
    
    public User(int idNum){
        this.idNum = idNum; // create a unique id number for each user (cannot be changed)
    }
    
    public int getUserId(){
        return this.idNum;
    }
    
}
