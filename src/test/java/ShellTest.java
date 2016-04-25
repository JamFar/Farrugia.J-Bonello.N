/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */

import com.mycompany.cps2002.farrugia.bonello.ShellClass;
import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test
 */
public class ShellTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ShellTest() {
        super();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ShellTest.class);
    }

    /**
     * Rigorous test
     */
    public void testAdd(){
        ShellClass test = new ShellClass();
        assertEquals(4, test.add(2,2)); 
        assertEquals(0, test.add(0,0));
        assertEquals(3, test.add(1,2));        
    }
}