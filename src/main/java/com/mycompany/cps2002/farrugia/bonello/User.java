
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author Farrugia, Bonello
 */
public class User {
    
    static private int userCount;
    final private int idNum;    
    
    public User(){
        idNum = userCount + 1;  // create a unique id number for each user (cannot be changed)
    }
    
    public int getUserId(){
        return this.idNum;
    }
    
}
