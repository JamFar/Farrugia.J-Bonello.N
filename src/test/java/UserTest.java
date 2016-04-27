
import com.mycompany.cps2002.farrugia.bonello.Book;
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
        User user = new User();
        assertEquals(0, user.getUserId());
        User user2 = new User();
        assertEquals(1, user2.getUserId());
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        assertEquals(4, u3.getUserId());
    }
    
    @Test
    public void loanTest(){
        User user = new User();
        Book b1 = new Book();
        user.loanBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().contains(b1));
        user.returnBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().isEmpty());
        user.returnBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().isEmpty());
        user.loanBook(b1);
        user.loanBook(b1);
        Assert.assertTrue(user.getCurrentlyLoanedBooks().size() == 1);
    }
}
