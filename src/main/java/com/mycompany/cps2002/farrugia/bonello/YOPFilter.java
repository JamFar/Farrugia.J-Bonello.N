package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public class YOPFilter extends Filter{
    
    private final int yop;
    
    public YOPFilter(int yop){
        this.yop = yop;
    }

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
