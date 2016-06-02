package com.mycompany.cps2002.farrugia.bonello;

/**
 * Observer abstraction used to notify Users of changes in the Book subject.
 * @author James
 */
public abstract class Observer {
    
    /**
     * Will update the new position of the observer to that specified in "entry".
     * @param entry The updated position of a particular book queue.
     */
    public abstract void update(LoanTableEntry entry);
    
}
