package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public class GenreFilter extends Filter{
    
    private final Genre genre;
    
    public GenreFilter(Genre genre){
        this.genre = genre;
    }
    
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
