
package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 *
 * @author Farrugia, Bonello
 */
public class Library {
    
    private final ArrayList<User> users;
    private final Catalogue catalogue;
    /**
     * Library constructor. Initialises the Library
     */
    public Library(){
        users = new ArrayList<User>();
        catalogue = Catalogue.getInstance();
    }
    /**
     * Checks if user already exists in the Library system
     * @param user Check if this user exists
     * @return true if user exists, false if not
     */
    public boolean userExists(User user){
        for(User u : users){
            if(user.getUserId() == u.getUserId()){
                return true;
            }
        }
        return false;
    }
    /**
     * If user does not exist, add new user
     * @param user Add this user to system
     */
    public void addUser(User user){
        if(!userExists(user)){
            users.add(user);
        }
    }
    /**
     * Delete existing user from library
     * @param user User to be deleted
     */
    public void removeUser(User user){
        if(userExists(user)){
            users.remove(user);
        }
    }
    /**
     * Loan book to an existing User
     * @param book Book to be loaned
     * @param user User to loan book to.
     */
    public void loanBookTo(Book book, User user){
        user.loanBook(book);
    }
    /**
     * Return a loaned Book back to library
     * @param book Book to be returned
     */
    public void returnBook(Book book){
        for(User u : users){
            if(u.getCurrentlyLoanedBooks().contains(book)){
                u.returnBook(book);
                return;
            }
        }
    }
    /**
     * Returns the library catalogue 
     * @return the library catalogue 
     */
    public Catalogue getCatalogue(){
        return catalogue;
    }
    /**
     * Returns the list of all Users
     * @return list of all users
     */
    public ArrayList<User> getUsers(){
        return users;
    }
}
