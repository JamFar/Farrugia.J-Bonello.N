
package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 *
 * @author Farrugia, Bonello
 */
public class Catalogue {
    
    private static Catalogue instance = null;
    private final ArrayList<Book> stock;
    
    private Catalogue(){
        stock = new ArrayList<Book>();
    }
    /**
     * Returns the instance of catalogue
     * @return The instance of catalogue
     */
    public static Catalogue getInstance(){
        if(instance == null){
            instance = new Catalogue();
        }
        return instance;
    }
    /**
     * Add a new book to the stock 
     * @param book Book to be added
     */
    public void addBook(Book book){
        stock.add(book);
    }
    
    /**
     * Returns a list of all the books in stock.
     * @return A list of all books in stock.
     */
    public ArrayList<Book> getAllBooks(){
        return stock;
    }
    /**
     * Clears all the books in stock
     * Used for testing purposes in JUnit tests
     */
    public void clear(){
        stock.clear();
    }
    
    /**
     * Search for books by Filter
     * @param bookFilter Filter to be applied
     * @return List of books matching filter
     */
    public ArrayList<Book> searchForBooks(Filter bookFilter){
        return bookFilter.search(stock);
    }
}
