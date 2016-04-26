
package com.mycompany.cps2002.farrugia.bonello;

import java.util.Calendar;

/**
 *
 * @author Farrugia, Bonello
 */
public class Book{
    
    private Genre.genre genre;  // the book's genre
    private User loanedTo;      // the user the book was loaned to
    private int yop;            // the year of publication. Will be between year 0 and this year
    private int edition;        // the book's edition
    
    public void setGenre(Genre.genre genre){
        this.genre = genre;
    }
    
    public void setLoanedUser(User loanedTo){
        this.loanedTo = loanedTo;
    }
    
    public void setYearOfPub(int yop) throws OutOfBoundsException{
        int thisYear = Calendar.YEAR;
        if(yop >= 0 && yop <= thisYear){
            this.yop = yop;
        }else{
            throw new OutOfBoundsException(0, thisYear);
        }
    }
    
    public void setEdition(int edition) throws OutOfBoundsException{
        if(edition >= 0){
            this.edition = edition;
        }else{
            throw new OutOfBoundsException(true, 0);
        }
    }
}
