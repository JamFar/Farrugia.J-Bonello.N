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
        System.out.println("Creating user with id "+idNum);
    }

    /**
     * Returns the User's unique id.
     *
     * @return The User's unique id number.
     */
    public int getUserId() {
        return this.idNum;
    }

    public ArrayList<Book> getCurrentlyLoanedBooks() {
        return currentlyLoanedBooks;
    }

    public void setCurrentlyLoanedBooks(ArrayList<Book> currentlyLoanedBooks) {
        this.currentlyLoanedBooks = currentlyLoanedBooks;
    }

    public ArrayList<Book> getAllLoanedBooks() {
        return allLoanedBooks;
    }

    public void setAllLoanedBooks(ArrayList<Book> allLoanedBooks) {
        this.allLoanedBooks = allLoanedBooks;
    }

    /**
     * Adds a book to the user's book list, while changing the book's status,
     * adding a new timestamp, and updating its current user.
     *
     * @param book The book to be loaned.
     */
    public void loanBook(Book book) {
        if (!this.currentlyLoanedBooks.contains(book)) {
            if (this.currentlyLoanedBooks.size() < 3) {
                if (!book.getLoanedStatus()) {

                    try {
                        int year = Calendar.getInstance().get(Calendar.YEAR);
                        int month = Calendar.getInstance().get(Calendar.MONTH);
                        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

                        book.setLoanDate(year, month, day);
                        book.setLoanUser(this);
                        book.setLoanedStatus(true);
                        this.currentlyLoanedBooks.add(book);
                        this.allLoanedBooks.add(book);

                    } catch (OutOfBoundsException e) {
                        System.err.println("Error in extracting current date.");
                    }
                } else {
                    System.err.println("Book is already loaned out.");
                }
            } else {
                System.err.println("User exceeds maximum loan allowance of 3 books.");
            }
        } else {
            System.err.println("User is already currently loaning this book.");
        }
    }

    /**
     * Removes the book from the user's book list, and resets the book's status
     * and user.
     *
     * @param book The book to be removed.
     */
    public void returnBook(Book book) {

        if (this.currentlyLoanedBooks.contains(book)) {
            book.setLoanedStatus(false);
            book.setLoanUser(null);
            this.currentlyLoanedBooks.remove(book);
        } else {
            System.err.println("User does not currently have this book.");
        }
    }

}
