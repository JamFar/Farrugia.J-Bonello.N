package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 * A subclass of the Filter abstraction. This filter will filter out books according to their genre.
 * @author James
 */
public class GenreFilter extends Filter{
    
    private final Genre genre;
    
    public GenreFilter(Genre genre){
        this.genre = genre;
        this.type = FilterType.GENRE;
    }
    
    /**
     * Searches for any books in "books" that have the title specified in the class-wide variable "genre".
     * @param books The search space of the method.
     * @return A smaller or equal sized list of books derived from "books".
     */
    @Override
    public ArrayList<Book> search(ArrayList<Book> books) {
        ArrayList<Book> filteredList = new ArrayList<Book>();
        for(Book current: books){
           if(current.getGenre() == genre){
               filteredList.add(current);
           }
        }
        return filteredList;
    }
    
}
