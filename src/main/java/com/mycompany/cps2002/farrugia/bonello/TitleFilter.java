package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 * A subclass of the Filter abstraction. This filter will filter out books according to their title.
 * @author James
 */
public class TitleFilter extends Filter{
    
    private final String title;
    
    public TitleFilter(String title){
        this.title = title;
        this.type = FilterType.TITLE;
    }

    /**
     * Searches for any books in "books" that have the title specified in the class-wide variable "title".
     * @param books The search space of the method.
     * @return A smaller or equal sized list of books derived from "books".
     */
    @Override
    public ArrayList<Book> search(ArrayList<Book> books) {
        ArrayList<Book> filteredList = new ArrayList<Book>();
        for(Book current: books){
           if(current.getTitle().toLowerCase().contains(title.toLowerCase())){
               filteredList.add(current);
           }
        }
        return filteredList;
    }    
}
