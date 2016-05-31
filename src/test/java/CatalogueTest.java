
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.Catalogue;
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
public class CatalogueTest {

    public CatalogueTest() {
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

    @Test
    public void getAllBooksTest() {
        Catalogue c = Catalogue.getInstance();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        assertEquals(4, c.getAllBooks().size());
        c.clear();
    }
}
