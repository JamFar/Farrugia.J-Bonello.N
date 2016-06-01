
package com.mycompany.cps2002.farrugia.bonello;

import java.util.ArrayList;

public class LoanQueue {
    
    ArrayList<User> queue;
    
    public LoanQueue(){
        queue = new ArrayList<User>();
    }
    
    public void addUser(User interestedUser){
        for(User u : queue){
            if(u == interestedUser){
                return;
            }
        }
        queue.add(interestedUser);
    }
    
    public User popUser(){
        if(queue.isEmpty()){
            return null;
        }else{
            User first = queue.get(0);
            queue.remove(first);
            return first;
        }
    }
    
}
