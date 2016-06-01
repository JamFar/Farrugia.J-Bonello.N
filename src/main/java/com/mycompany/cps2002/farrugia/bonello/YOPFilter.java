package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 * A subclass of the Filter abstraction. This filter will filter out books according to their year of publication.
 * @author James
 */
public class YOPFilter extends Filter{
    
    private final int yop;
    
    public YOPFilter(int yop){
        this.yop = yop;
        this.type = FilterType.YOP;
    }

    /**
     * Searches for any books in "books" that have the title specified in the class-wide variable "yop".
     * @param books The search space of the method.
     * @return A smaller or equal sized list of books derived from "books".
     */
    @Override
    public ArrayList<Book> search(ArrayList<Book> books) {
        ArrayList<Book> filteredList = new ArrayList<Book>();
        for(Book current: books){
           if(current.getYop()== yop){
               filteredList.add(current);
           }
        }
        return filteredList;
    }
        
}
