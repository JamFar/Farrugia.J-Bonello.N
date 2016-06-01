
package com.mycompany.cps2002.farrugia.bonello;

public class LoanTableEntry {
    
    Book book;
    int position;
    /**
     * Assigns a new loan table entry to a book
     * @param book Book to be added
     * @param position Position in which book is added
     */
    public LoanTableEntry(Book book, int position){
        this.book = book;
        this.position = position;
    }
}
