package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 * A concrete filter which is sub-classed from the Filter abstraction. This filter is composed of layers of user specified filters to produce a single composite filter capable of filtering according to genre, year of publication and/or title.
 * @author James
 */
public class BookFilter extends Filter{

    ArrayList<Filter> appliedFilters = new ArrayList<Filter>();
    
    public BookFilter(){
        type = FilterType.COMPOSITE;
    }
    
    /**
     * This search function will apply all the available filters to reduce the search-space.
     * @param books The search-space. 
     * @return A smaller or equal sized list of books derived from "books".
     */
    @Override
    public ArrayList<Book> search(ArrayList<Book> books) {
        ArrayList<Book> filteredList = new ArrayList<Book>();
        for(Filter filter : appliedFilters){
            filteredList = filter.search(books);
        }
        return filteredList;
    }
    
    /**
     * Inserts a new filter to the list of active filters.
     * @param filter The new filter to be added.
     */
    public void insertFilter(Filter filter){
        appliedFilters.add(filter);        
    }
    
    /**
     * Removes a new filter from the list of active filters.
     * @param filter The new filter to be removed.
     */
    public void removeFilter(Filter filter){
        ArrayList<Filter> remove = new ArrayList<Filter>();
        for(Filter ftr : appliedFilters){
            if(ftr == filter){
                //appliedFilters.remove(ftr);
                remove.add(ftr);
            }
        }
        appliedFilters.removeAll(remove);
        System.err.println("No such filter applied.");
    }
    
}
