
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
    
    public static Catalogue getInstance(){
        if(instance == null){
            instance = new Catalogue();
        }
        return instance;
    }
    
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
    
    public void clear(){
        stock.clear();
    }
}
