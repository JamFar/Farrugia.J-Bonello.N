package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public abstract class Filter {
    
    protected abstract ArrayList<Book> search(ArrayList<Book> books);
    protected FilterType type = FilterType.NONE;  
    
    public String getType(){
        switch(type){
            case YOP: return "YOP";
            case TITLE: return "TITLE";
            case GENRE: return "GENRE";
            case COMPOSITE: return "COMPOSITE";
            default: return "NONE";
        }
    }
}
