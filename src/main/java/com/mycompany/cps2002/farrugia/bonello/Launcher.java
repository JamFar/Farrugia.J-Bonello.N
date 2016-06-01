
package com.mycompany.cps2002.farrugia.bonello;

public class Launcher {
    
    public static void main(String[] args){
        User a = new User();
        User b = new User();
        User c = new User();
        Book b1 = new Book("Hello");
        b.loanBook(b1);
        a.loanBook(b1);
        c.loanBook(b1);
        b.returnBook(b1);
    }
}
