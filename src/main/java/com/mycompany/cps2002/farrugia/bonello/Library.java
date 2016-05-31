
package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

/**
 *
 * @author Farrugia, Bonello
 */
public class Library {
    
    private final ArrayList<User> users;
    private Catalogue catalogue;
    
    public Library(){
        users = new ArrayList<User>();
        catalogue = Catalogue.getInstance();
    }
    
    public boolean userExists(User user){
        for(User u : users){
            if(user.getUserId() == u.getUserId()){
                return true;
            }
        }
        return false;
    }
    
    public void addUser(User user){
        if(!userExists(user)){
            users.add(user);
        }
    }
    
    public void removeUser(User user){
        if(userExists(user)){
            users.remove(user);
        }
    }
    
    public void loanBookTo(Book book, User user){
        user.loanBook(book);
    }
    
    public void returnBook(Book book){
        for(User u : users){
            if(u.getCurrentlyLoanedBooks().contains(book)){
                u.returnBook(book);
                return;
            }
        }
    }
    public Catalogue getCatalogue(){
        return catalogue;
    }
    public ArrayList<User> getUsers(){
        return users;
    }
}
