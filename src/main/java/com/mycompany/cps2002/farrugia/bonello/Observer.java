package com.mycompany.cps2002.farrugia.bonello;

/**
 * Observer abstraction used to notify users.
 * @author James
 */
public abstract class Observer {
    
    /**
     * 
     * @param entry 
     */
    public abstract void update(LoanTableEntry entry);
    
}
