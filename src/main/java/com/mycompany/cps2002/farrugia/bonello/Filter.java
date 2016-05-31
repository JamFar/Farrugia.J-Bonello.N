package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public abstract class Filter {
    
    public abstract ArrayList<Book> search(ArrayList<Book> books);
    
    public void insertFilter(Filter filter){        
    }
    
    public void removeFilter(Filter filter){        
    }    
}
