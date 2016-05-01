
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.OutOfBoundsException;
import com.mycompany.cps2002.farrugia.bonello.User;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Farrugia, Bonello
 */
public class UserTest {
    
    public UserTest() {
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
    public void uniqueIdTest(){
        User u0 = new User();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u4 = new User();
        Assert.assertFalse(u0.getUserId() == u1.getUserId());
        Assert.assertFalse(u1.getUserId() == u2.getUserId());
        Assert.assertFalse(u2.getUserId() == u3.getUserId());
        Assert.assertFalse(u3.getUserId() == u4.getUserId());
    }
    
    @Test
    public void loanTest(){
        User user = new User();
        User user2 = new User();
        Book b1 = new Book("The Death of Dr. Larry");
        user.loanBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().contains(b1));
        user.returnBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().isEmpty());
        user.returnBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().isEmpty());
        user.loanBook(b1);
        user.loanBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().size() == 1);
        user2.loanBook(b1);
        Assert.assertTrue(user2.getCurrentlyLoanedBooks().isEmpty());
        Book b2 = new Book("Some Book");
        user2.loanBook(b2);
        Assert.assertEquals(1, user2.getCurrentlyLoanedBooks().size());
        user2.loanBook(b2);
        Assert.assertEquals(1, user2.getCurrentlyLoanedBooks().size());
        
        User u3 = new User();
        Book b3 = new Book("Another Book");
        u3.loanBook(b3);
        u3.loanBook(b3);
        Assert.assertEquals(1, u3.getCurrentlyLoanedBooks().size());
        try{
            b3.setLoanDate(1990, 1, 1);
        }catch(OutOfBoundsException e){}
        u3.loanBook(b1);
        Assert.assertEquals(1, u3.getCurrentlyLoanedBooks().size());
        
        Book b_3 = new Book("asdasd");
        user.loanBook(b1);
        user.loanBook(b2);
        user.loanBook(b_3);
        Book b4 = new Book("B4");
        user.loanBook(b4);
        Assert.assertEquals(3, user.getCurrentlyLoanedBooks().size());
    }
    
    @Test
    public void overdueTest(){
        try{
            User user = new User();
            Book b = new Book("Black Beauty");
            user.loanBook(b);
            b.setLoanDate(1990, 1, 1);
            Book b2 = new Book("Macbeth");
            user.loanBook(b2);
            assertEquals(1, user.getCurrentlyLoanedBooks().size());    // he only has 1 book (b1) since b1 is overdue, b2 cannot be loaned.
        }catch(OutOfBoundsException e){    
        }
    }
    
    @Test
    public void getAllLoanedTest(){
            User user = new User();
            Book b = new Book("Black Beauty");
            user.loanBook(b);
            Book b2 = new Book("Macbeth");
            user.loanBook(b2);
            assertEquals(2, user.getCurrentlyLoanedBooks().size()); 
            assertEquals(2, user.getAllLoanedBooks().size());
            user.returnBook(b2);
            assertEquals(1, user.getCurrentlyLoanedBooks().size());
            assertEquals(2, user.getAllLoanedBooks().size());
    }
    
    @Test public void LoanUnavailableBookTest(){
        User u1 = new User();
        User u2 = new User();
        Book b1 = new Book("Hamlet");
        u1.loanBook(b1);
        u1.loanBook(b1);
        assertEquals(u1.getCurrentlyLoanedBooks().size(),1);
        assertEquals(u2.getCurrentlyLoanedBooks().size(),0);
    
    }
}
