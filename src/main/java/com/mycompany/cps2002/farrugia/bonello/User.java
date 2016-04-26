package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Farrugia, Bonello
 */
public class User {

    static private int userCount = 0;   // this belongs to the class
    final private int idNum;            // this belongs to the user
    ArrayList<Book> currentlyLoanedBooks;
    ArrayList<Book> allLoanedBooks;

    /**
     * User constructor. Initialises a new User with a unique id.
     */
    public User() {
        idNum = userCount++;  // create a unique id number for each user (cannot be changed)
        currentlyLoanedBooks = new ArrayList<Book>();
        allLoanedBooks = new ArrayList<Book>();
    }

    /**
     * Returns the User's unique id.
     *
     * @return The User's unique id number.
     */
    public int getUserId() {
        return this.idNum;
    }

    public void loanBook(Book book) throws OutOfBoundsException {
        
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        
        book.setLoanDate(year, month, day);
        book.setLoanUser(this);
        book.setLoanedStatus(true);
        this.currentlyLoanedBooks.add(book);
        this.allLoanedBooks.add(book);
        
    }
    
    public void returnBook(Book book) {
        
        book.setLoanedStatus(false);
        book.setLoanUser(null);
        this.currentlyLoanedBooks.remove(book);
        
    }

}
