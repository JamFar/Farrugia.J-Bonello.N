
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.User;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
    public void yearOfPub_boundsTest_tooSmall() {
        Book b = new Book("Trial by Error");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setYearOfPub(-1);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void yearOfPub_boundsTest_tooLarge() {
        Book b = new Book("Computer Science Made Easy");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setYearOfPub(2023);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void yearOfPub_boundsTest_valid() {
        Book b = new Book("Harry Potter");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setYearOfPub(2012);
        assertThat(errContent.toString(), not("Out of Bounds." + System.getProperty("line.separator")));
    }

    @Test
    public void edition_boundsTest_tooSmall() {
        Book b = new Book("The Hunger Games");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setEdition(-1);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void edition_boundsTest_valid() {
        Book b = new Book("The Help");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setEdition(12);
        assertThat(errContent.toString(), not("Out of Bounds." + System.getProperty("line.separator")));
    }

    @Test
    public void loanDate_boundsTest_largeYear() {
        Book b = new Book("The Railway Children");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(2020, 4, 4);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void loanDate_boundsTest_thisYear() {
        Book b = new Book("The Silmarillion");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(2016, 4, 4);
        assertThat(errContent.toString(), not("Out of Bounds." + System.getProperty("line.separator")));
    }

    @Test
    public void loanDate_boundsTest_smallYear() {
        Book b = new Book("The Treasure Island");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(-1, 4, 4);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void loanDate_boundsTest_largeMonth() {
        Book b = new Book("The Mysterious Skull");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(2016, 12, 4);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void loanDate_boundsTest_smallMonth() {
        Book b = new Book("The Invisible Man");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(2016, -1, 4);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void loanDate_boundsTest_largeDay() {
        Book b = new Book("The Headless Horseman");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(2016, 4, 34);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void loanDate_boundsTest_smallDay() {
        Book b = new Book("Lord of the Rings");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setLoanDate(2016, 4, -1);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void loanedTo() {
        Book b = new Book("Spiderman");
        User user = new User();
        b.setLoanUser(user);
        assertEquals(b.getLoanedTo(), user);
    }

    @Test
    public void loanedTo_false() {
        Book b = new Book("Superman");
        assertEquals(b.getLoanedTo(), null);
    }

    @Test
    public void getEdition_correct() {
        Book b = new Book("The Maze Runner");
        b.setEdition(1);
        assertEquals(b.getEdition(), 1);
    }

    @Test
    public void getEdition_negative() {
        Book b = new Book("The Maze Runner");
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        b.setEdition(-21);
        assertEquals("Out of Bounds." + System.getProperty("line.separator"), errContent.toString());
    }

    @Test
    public void getTimeStamps_test() {
        Book b = new Book("Programming for dummies");
        Assert.assertTrue(b.getTimeStamps().isEmpty());
        User u1 = new User();
        User u2 = new User();
        b.setLoanUser(u1);

        assertEquals(b.getLatestTimeStamp(), null);
        
        b.setLoanDate(2016, 10, 10);
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy");
        String dateFormatted = fmt.format(b.getLatestTimeStamp().getTime());
        
        fmt = new SimpleDateFormat("dd MMM yyyy");
        fmt.setCalendar(b.getLatestTimeStamp());
        dateFormatted = fmt.format(b.getLatestTimeStamp().getTime());
        assertEquals(b.getTimeStamps().size(), 1);
        assertEquals(dateFormatted, "10 Nov 2016");
        b.setLoanUser(u2);
        b.setLoanDate(2016, 11, 10);

        fmt = new SimpleDateFormat("dd MMM yyyy");
        fmt.setCalendar(b.getLatestTimeStamp());
        dateFormatted = fmt.format(b.getLatestTimeStamp().getTime());
        assertEquals(dateFormatted, "10 Dec 2016");
        assertEquals(b.getTimeStamps().size(), 2);
    }
}
