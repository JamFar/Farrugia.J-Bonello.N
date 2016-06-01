package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 * An abstract class representing a filter. Takes a list of books and returns a smaller or equal sized list of books.
 * @author James
 */
public abstract class Filter {
    
    protected abstract ArrayList<Book> search(ArrayList<Book> books);
    protected FilterType type;  // the type of filter used (enum)
    
    public String getType(){
        switch(type){
            case YOP: return "YOP";
            case TITLE: return "TITLE";
            case GENRE: return "GENRE";
            default: return "COMPOSITE";
        }
    }
}
