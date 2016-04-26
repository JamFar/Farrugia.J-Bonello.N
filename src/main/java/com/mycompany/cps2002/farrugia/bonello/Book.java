
package com.mycompany.cps2002.farrugia.bonello;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Farrugia, Bonello
 */
public class Book{
    
    private Genre.genre genre;  // the book's genre
    private User loanedTo;      // the user the book was loaned to
    private int yop;            // the year of publication. Will be between year 0 and this year
    private int edition;        // the book's edition
    private GregorianCalendar loanDate; // the book's loan date
    
    /**
     * Sets the genre of the book.
     * @param genre The genre/category of the book.
     */
    public void setGenre(Genre.genre genre){
        this.genre = genre;
    }
    
    /**
     * Sets the user that the book was loaned to.
     * @param loanedTo The user that the book was loaned to.
     */
    public void setLoanedUser(User loanedTo){
        this.loanedTo = loanedTo;
    }
    
    /**
     * Sets the year of publication of the book.
     * @param yop The year of publication of the book.
     * @throws OutOfBoundsException Thrown when the year entered is unreasonable.
     */
    public void setYearOfPub(int yop) throws OutOfBoundsException{
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        
        if(yop >= 0 && yop <= thisYear){
            this.yop = yop;
        }else{
            throw new OutOfBoundsException(0, thisYear);
        }
    }
    
    /**
     * Sets the edition of the book.
     * @param edition The edition of the book.
     * @throws OutOfBoundsException Thrown when the edition entered is unreasonable.
     */
    public void setEdition(int edition) throws OutOfBoundsException{
        if(edition >= 0){
            this.edition = edition;
        }else{
            throw new OutOfBoundsException(true, 0);
        }
    }
    
    /**
     * Sets the date when the book was loaned.
     * @param year  The year the book was loaned.
     * @param month The month of the previously mentioned year.
     * @param day The day of the previously mentioned month.
     * @throws OutOfBoundsException Thrown when either the year, month or day entered are unreasonable.
     */
    public void setLoanDate(int year, int month, int day) throws OutOfBoundsException{
        
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        if((year >= 0 && year <= thisYear) && (month >= 0 && month < 12) && (day > 0 && day <= 31)){
            GregorianCalendar date = new GregorianCalendar(year, month, day);
            this.loanDate = date;
        }else{
            throw new OutOfBoundsException();
        }
    }

    /**
     * Returns the genre of the book.
     * @return The genre.
     */
    public Genre.genre getGenre() {
        return genre;
    }

    /**
     * Returns the User the book was loaned to.
     * @return The User the book was loaned to.
     */
    public User getLoanedTo() {
        return loanedTo;
    }

    /**
     * Returns the year of publication of the book.
     * @return The year of publication.
     */
    public int getYop() {
        return yop;
    }

    /**
     * Returns the edition of the book.
     * @return The edition number.
     */
    public int getEdition() {
        return edition;
    }

    /**
     * Returns the date when the book was loaned.
     * @return The loan date.
     */
    public GregorianCalendar getLoanDate() {
        return loanDate;
    }
    
    
}
