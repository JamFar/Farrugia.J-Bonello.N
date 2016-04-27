
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.Catalogue;
import com.mycompany.cps2002.farrugia.bonello.Genre;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void searchTest() {
        try {
            Catalogue c = new Catalogue();
            Book b1 = new Book("The Sorcerer's Enigma");
            b1.setGenre(Genre.ADVENTURE);
            b1.setYearOfPub(1890);
            Book b2 = new Book("Moby Dick");
            b2.setGenre(Genre.ACTION);
            b2.setYearOfPub(1890);
            Book b3 = new Book("The Book of Love");
            b3.setGenre(Genre.BIOGRAPHY);
            b3.setYearOfPub(2016);
            Book b4 = new Book("Life of Pi");
            b4.setGenre(Genre.BIOGRAPHY);
            b4.setYearOfPub(2014);
            c.addBook(b1);
            c.addBook(b2);
            c.addBook(b3);
            c.addBook(b4);
            assertEquals(1, c.searchByTitle("Sorcerer").size());
            assertEquals(2, c.searchByTitle("of").size());
            assertEquals(0, c.searchByTitle("something").size());
            assertEquals(2, c.searchByGenre(Genre.BIOGRAPHY).size());
            assertEquals(1, c.searchByGenre(Genre.ADVENTURE).size());
            assertEquals(0, c.searchByGenre(Genre.UNKNOWN).size());
            assertEquals(2, c.searchByYOP(1890).size());
            assertEquals(1, c.searchByYOP(2016).size());
            assertEquals(0, c.searchByYOP(12).size());
        } catch (OutOfBoundsException e) {

        }
    }
    
    @Test
    public void getAllBooksTest(){
        Catalogue c = new Catalogue();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        assertEquals(4, c.getAllBooks().size());
    }
}