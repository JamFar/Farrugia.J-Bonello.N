//Testing Connection
package com.mycompany.cps2002.farrugia.bonello;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Farrugia, Bonello
 */
public class Book{
    
    private static int bookCount = 0;
    
    private final int bookId;   // the book's unique identification number
    private final String title;
    private Genre genre;  // the book's genre
    private User loanedTo;      // the user the book is currently loaned to
    private int yop;            // the year of publication. Will be between year 0 and this year
    private int edition;        // the book's edition
    private final ArrayList<GregorianCalendar> timeStamps; // the book's loan dates
    private boolean currentlyLoaned;        // is the book currently being loaned?
    
    /**
     * Book constructor. Initialises book unique id and sets up timestamp array list.
     * @param title The title of the book.
     */
    public Book(String title){
        this.title = title;
        this.bookId = bookCount++;
        timeStamps = new ArrayList<GregorianCalendar>();
        currentlyLoaned = false;
        genre = Genre.UNKNOWN;
    }
    
    /**
     * Sets the genre of the book.
     * @param genre The genre/category of the book.
     */
    public void setGenre(Genre genre){
        this.genre = genre;
    }
    
    /**
     * Sets the user that the book was loaned to.
     * @param loanedTo The user that the book was loaned to.
     */
    public void setLoanUser(User loanedTo){
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
            throw new OutOfBoundsException();
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
            throw new OutOfBoundsException();
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
            this.timeStamps.add(date);
        }/*else{
            throw new OutOfBoundsException();
        }*/
    }
    
    /**
     * Sets the currently loaned boolean to "currentlyLoaned"
     * @param currentlyLoaned true if the book is currently loaned, false otherwise.
     */
    public void setLoanedStatus(boolean currentlyLoaned){
        this.currentlyLoaned = currentlyLoaned;
    }

    /**
     * Returns the genre of the book.
     * @return The genre.
     */
    public Genre getGenre() {
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
     * Returns the title of the book.
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the all the dates when the book was loaned.
     * @return The loan dates.
     */
    public ArrayList<GregorianCalendar> getTimeStamps() {
        return timeStamps;
    }
    
    /**
     * Returns the very last date it was loaned.
     * @return The latest date the book was loaned.
     */
    public GregorianCalendar getLatestTimeStamp(){
        if(timeStamps.isEmpty()){
            return null;
        }else
            return timeStamps.get(timeStamps.size()-1);
    }
    
    /**
     * Returns the status of the book.
     * @return true if currently being loaned, false otherwise.
     */
    public boolean getLoanedStatus(){
        return currentlyLoaned;
    }
    
    
}
