package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public class TitleFilter extends Filter{
    
    private final String title;
    
    public TitleFilter(String title){
        this.title = title;
        this.type = FilterType.TITLE;
    }

    @Override
    public ArrayList<Book> search(ArrayList<Book> books) {
        ArrayList<Book> filteredList = new ArrayList<Book>();
        for(Book current: books){
           if(current.getTitle().equalsIgnoreCase(title)){
               filteredList.add(current);
           }
        }
        return filteredList;
    }
    
    
}
