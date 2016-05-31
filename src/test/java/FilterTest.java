
import com.mycompany.cps2002.farrugia.bonello.Book;
import com.mycompany.cps2002.farrugia.bonello.BookFilter;
import com.mycompany.cps2002.farrugia.bonello.Catalogue;
import com.mycompany.cps2002.farrugia.bonello.Genre;
import com.mycompany.cps2002.farrugia.bonello.GenreFilter;
import com.mycompany.cps2002.farrugia.bonello.TitleFilter;
import com.mycompany.cps2002.farrugia.bonello.YOPFilter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FilterTest {

    public FilterTest() {
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
    public void GenreFilter_Test() {
        Catalogue c = Catalogue.getInstance();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        b1.setGenre(Genre.ACTION);
        b2.setGenre(Genre.ADVENTURE);
        b3.setGenre(Genre.MYSTERY);
        b4.setGenre(Genre.BIOGRAPHY);
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        BookFilter bf = new BookFilter();
        bf.insertFilter(new GenreFilter(Genre.ACTION));
        assertEquals("Book 1", bf.search(c.getAllBooks()).get(0).getTitle());
        c.clear();
    }
    
    @Test
    public void TitleFilter_Test() {
        Catalogue c = Catalogue.getInstance();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        BookFilter bf = new BookFilter();
        bf.insertFilter(new TitleFilter("Book 1"));
        assertEquals("Book 1", bf.search(c.getAllBooks()).get(0).getTitle());
        c.clear();
    }
    
@Test
    public void YOP_Test() {
        Catalogue c = Catalogue.getInstance();
        Book b1 = new Book("Book 1");
        Book b2 = new Book("Book 2");
        Book b3 = new Book("Book 3");
        Book b4 = new Book("Book 4");
        b1.setYearOfPub(1972);
        b2.setYearOfPub(1996);
        b3.setYearOfPub(2016);
        b4.setYearOfPub(2011);
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        BookFilter bf = new BookFilter();
        bf.insertFilter(new YOPFilter(1972));
        assertEquals("Book 1", bf.search(c.getAllBooks()).get(0).getTitle());
        c.clear();
    }
    
    @Test
    public void Composite_Test() {
        Catalogue c = Catalogue.getInstance();
        Book b1 = new Book("Murder on the MotorBoats");
        Book b2 = new Book("Harry Potter");
        Book b3 = new Book("Drawing 101");
        Book b4 = new Book("Painting 101");
        b1.setYearOfPub(1972);
        b2.setYearOfPub(1996);
        b3.setYearOfPub(2016);
        b4.setYearOfPub(2011);
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        BookFilter bf = new BookFilter();
        bf.insertFilter(new TitleFilter("murder"));
        bf.insertFilter(new YOPFilter(1972));
        assertEquals("Murder on the MotorBoats", bf.search(c.getAllBooks()).get(0).getTitle());
        c.clear();
    }
    
    @Test
    public void Composite_Failure_Test() {
        Catalogue c = Catalogue.getInstance();
        Book b1 = new Book("Murder on the MotorBoats");
        Book b2 = new Book("Harry Potter");
        Book b3 = new Book("Drawing 101");
        Book b4 = new Book("Painting 101");
        b1.setYearOfPub(1972);
        b2.setYearOfPub(1996);
        b3.setYearOfPub(2016);
        b4.setYearOfPub(2011);
        c.addBook(b1);
        c.addBook(b2);
        c.addBook(b3);
        c.addBook(b4);
        BookFilter bf = new BookFilter();
        bf.insertFilter(new TitleFilter("murder"));
        bf.insertFilter(new YOPFilter(1973));
        assertEquals(0, bf.search(c.getAllBooks()).size());
        c.clear();
    }
}
