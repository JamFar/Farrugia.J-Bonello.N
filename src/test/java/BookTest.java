
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.OutOfBoundsException;
import com.mycompany.cps2002.farrugia.bonello.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
    public void yearOfPub_boundsTest_tooSmall(){
        Book b = new Book("Trial by Error");
        try{
            b.setYearOfPub(-1);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void yearOfPub_boundsTest_tooLarge(){
        Book b = new Book("Computer Science Made Easy (yeah right)");
        try{
            b.setYearOfPub(2023);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void yearOfPub_boundsTest_valid(){
        Book b = new Book("Harry Potter");
        boolean exceptionThrown = false;
        try{
            b.setYearOfPub(2012);
        }catch(Exception e){
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
    }
    
    @Test
    public void edition_boundsTest_tooSmall(){
        Book b = new Book("The Hunger Games");
        try{
            b.setEdition(-1);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void edition_boundsTest_valid(){
        Book b = new Book("The Help");
        boolean exceptionThrown = false;
        try{
            b.setEdition(12);
        }catch(Exception e){
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
    }
    
    @Test
    public void loanDate_boundsTest_largeYear(){
        Book b = new Book("The Railway Children");
        try{
            b.setLoanDate(2020, 4, 4);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    @Test
    public void loanDate_boundsTest_thisYear(){
        Book b = new Book("The Silmarillion");
        boolean exceptionThrown = false;
        try{
            b.setLoanDate(2016, 4, 4);
        }catch(Exception e){
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
    }
    
    @Test
    public void loanDate_boundsTest_smallYear(){
        Book b = new Book("The Treasure Island");
        try{
            b.setLoanDate(-1, 4, 4);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void loanDate_boundsTest_largeMonth(){
        Book b = new Book("The Mysterious Skull");
        boolean exceptionThrown = false;
        try{
            b.setLoanDate(2016, 12, 4);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void loanDate_boundsTest_smallMonth(){
        Book b = new Book("The Invisible Man");
        boolean exceptionThrown = false;
        try{
            b.setLoanDate(2016, -1, 4);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void loanDate_boundsTest_largeDay(){
        Book b = new Book("The Headless Horseman");
        boolean exceptionThrown = false;
        try{
            b.setLoanDate(2016, 4, 34);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test
    public void loanDate_boundsTest_smallDay(){
        Book b = new Book("Lord of the Rings");
        boolean exceptionThrown = false;
        try{
            b.setLoanDate(2016, 4, -1);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    }
    
    @Test public void loanedTo(){
        Book b = new Book("Spiderman");
        boolean exceptionThrown = false;
        User user = new User();
        try{
            b.setLoanUser(user);
        }catch(Exception e){
        }
        assertEquals(b.getLoanedTo(),user);
    }
    
    @Test public void loanedTo_false(){
        Book b = new Book("Superman");
        boolean exceptionThrown = false;
        try{
            assertEquals(b.getLoanedTo(),null);
        }catch(Exception e){
        }
    }
    
    @Test
    public void getEdition_correct(){
        Book b = new Book("The Maze Runner");
        try{
            b.setEdition(1);
        }catch(Exception e){
        }
        assertEquals(b.getEdition(),1);
    }
    
    @Test
    public void getEdition_negative(){
        Book b = new Book("The Maze Runner");
        try{
            b.setEdition(-21);
        }catch(Exception e){
            assertTrue(e instanceof OutOfBoundsException);
        }
    } 
    
    @Test
    public void getTimeStamps_test(){
        Book b = new Book("Programming for dummies");
        try{
           Assert.assertTrue(b.getTimeStamps().isEmpty());
           User u1 = new User();
           b.setLoanUser(u1);
           b.setLoanDate(2016, 10, 10);
           assertEquals(b.getTimeStamps().size(),1);
        }catch(Exception e){
        }
    }
}
