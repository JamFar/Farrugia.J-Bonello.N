
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.OutOfBoundsException;
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
public class BookTest {
    
    public BookTest() {
        super();
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
    public void yearOfPub_boundsTest(){
        Book b = new Book();
        try{
            b.setYearOfPub(-1);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void edition_boundsTest(){
        Book b = new Book();
        try{
            b.setEdition(-1);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void loanDate_boundsTest_largeYear(){
        Book b = new Book();
        try{
            b.setLoanDate(2020, 4, 4);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    @Test
    public void loanDate_boundsTest_thisYear(){
        Book b = new Book();
        boolean exceptionThrown = false;
        try{
            b.setLoanDate(2016, 4, 4);
        }catch(Exception e){
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
    }
}
