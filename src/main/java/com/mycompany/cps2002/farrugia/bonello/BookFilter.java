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
    
    public boolean isDuplicate(Filter filter){
        for(Filter ftr : appliedFilters){
            if(ftr.getType().equals(filter.getType())){
                return true;
            }
        }
        return false;
    }
    
    public void insertFilter(Filter filter){
        if(!isDuplicate(filter)){
            appliedFilters.add(filter);
        }else{
            System.err.println(filter.getType()+" filter already exists.");
        }
    }
    
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
