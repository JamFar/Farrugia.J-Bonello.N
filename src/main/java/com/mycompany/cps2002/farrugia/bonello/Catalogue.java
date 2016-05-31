
package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 *
 * @author Farrugia, Bonello
 */
public class Catalogue {
    
    private static Catalogue instance = null;
    private ArrayList<Book> stock;
    
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
    
    /**
     * Returns a list of all the books with title "title".
     * @param title The title of the book
     * @return A list of all books with the title "title".
     */
    public ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> result = new ArrayList<Book>();
        for(Book book : stock){
            if((book.getTitle().toLowerCase()).contains(title.toLowerCase())){
                result.add(book);
            }
        }
        return result;
    }
    
    /**
     * Returns a list of all the books with genre "genre".
     * @param genre The genre of the book
     * @return A list of all books with the genre "genre".
     */
    public ArrayList<Book> searchByGenre(Genre genre){
        ArrayList<Book> result = new ArrayList<Book>();
        for(Book book : stock){
            if(genre.toString().equals(book.getGenre().toString())){
                result.add(book);
            }
        }
        return result;
    }
    
    /**
     * Returns a list of all the books with year of publication "yop".
     * @param yop The year of publication of the book
     * @return A list of all books with the year of publication "yop".
     */
    public ArrayList<Book> searchByYOP(int yop){
        ArrayList<Book> result = new ArrayList<Book>();
        for(Book book : stock){
            if(yop == book.getYop()){
                result.add(book);
            }
        }
        return result;
    }
}
