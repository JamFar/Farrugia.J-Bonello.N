
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author Farrugia, Bonello
 */
public class User {
    
    static private int userCount = 0;   // this belongs to the class
    final private int idNum;            // this belongs to the user
    
    /**
     * User constructor. Initialises a new User with a unique id.
     */
    public User(){
        idNum = userCount++;  // create a unique id number for each user (cannot be changed)
    }
    
    /**
     * Returns the User's unique id.
     * @return The User's unique id number.
     */
    public int getUserId(){
        return this.idNum;
    }
    
}
