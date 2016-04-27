
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.Library;
import com.mycompany.cps2002.farrugia.bonello.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Farrugia, Bonello
 */
public class LibraryTest {
    
    public LibraryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void singleUserTest(){
        Library l = new Library();
        User u1 = new User();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        l.addUser(u1);
        l.getCatalogue().addBook(b1);
        l.getCatalogue().addBook(b2);
        l.getCatalogue().addBook(b3);
        l.getCatalogue().addBook(b4);
        l.loanBookTo(b1, u1);
        assertEquals(1, u1.getCurrentlyLoanedBooks().size());
        l.loanBookTo(b2, u1);
        assertEquals(2, u1.getCurrentlyLoanedBooks().size());
        l.loanBookTo(b3, u1);
        assertEquals(3, u1.getCurrentlyLoanedBooks().size());
        l.loanBookTo(b4, u1);
        assertEquals(3, u1.getCurrentlyLoanedBooks().size());
        l.loanBookTo(b1, u1);
        assertEquals(3, u1.getCurrentlyLoanedBooks().size());
    }
    
    @Test
    public void multipleUserTest(){
        Library l = new Library();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        Book b1 = new Book("Book 1");
        l.getCatalogue().addBook(b1);
        l.addUser(u1);
        l.addUser(u2);
        l.addUser(u3);
        l.loanBookTo(b1, u1);
        assertEquals(1, u1.getCurrentlyLoanedBooks().size());
        l.loanBookTo(b1, u2);
        assertEquals(0, u2.getCurrentlyLoanedBooks().size());
        l.loanBookTo(b1, u3);
        assertEquals(0, u3.getCurrentlyLoanedBooks().size());
    }
    
    @Test
    public void returnTest(){
        Library l = new Library();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        l.getCatalogue().addBook(b1);
        l.getCatalogue().addBook(b2);
        l.getCatalogue().addBook(b3);
        l.getCatalogue().addBook(b4);
        l.getCatalogue().addBook(b1);
        l.addUser(u1);
        l.addUser(u2);
        l.addUser(u3);
        l.loanBookTo(b1, u1);
        assertEquals(1, u1.getCurrentlyLoanedBooks().size());
        l.returnBook(b1);
        assertEquals(0, u1.getCurrentlyLoanedBooks().size());
        l.returnBook(b1);
        assertEquals(0, u1.getCurrentlyLoanedBooks().size());
    }
}
