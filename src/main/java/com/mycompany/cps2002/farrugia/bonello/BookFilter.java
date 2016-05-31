package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public class BookFilter extends Filter{

    ArrayList<Filter> appliedFilters = new ArrayList<Filter>();
    
    public BookFilter(){
        
    }
    
    @Override
    public ArrayList<Book> search(ArrayList<Book> books) {
        ArrayList<Book> filteredList = new ArrayList<Book>();
        for(Filter filter : appliedFilters){
            filteredList = filter.search(books);
        }
        return filteredList;
    }
    
    public Filter searchFilter(Filter filter){
        for(Filter ftr : appliedFilters){
            if(ftr)
        }
    }
    
    public void insertFilter(Filter filter){
        appliedFilters.add(filter);
    }
    
    public void removeFilter(Filter filter){
        
    }
    
}
