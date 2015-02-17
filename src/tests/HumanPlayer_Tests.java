package tests;

import org.junit.*;

import battleship.HumanLocation;
import battleship.HumanPlayer;
import battleship.Location;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HumanPlayer_Tests
{
    HumanPlayer p;
    HumanPlayer p1;
    
    ByteArrayOutputStream output;
    ByteArrayOutputStream errors;
    
    /**
     * Tests setup. Create new player object
     * Mock a human player horizontal ship at position 4, 6
     * with width 4 units
     *
     * Set the standard output to a variable
     * Redirect all errors to a variable
     */
    @Before
    public void setUp()
    {
        p = new HumanPlayer();
        
        p1 = mock(HumanPlayer.class);
        HumanLocation loc = new HumanLocation(4, 6, true, 4);
        when(p1.placeShip(1, true)).thenReturn(loc);
        
        output = new ByteArrayOutputStream();
        errors = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(errors));
    }
    
    /**
     * Set the standard system output and errors to NULL
     */
    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }
    
    /**
     * This method cannot be tested because it relies
     * on the user input from Scanner inside
     */
    @Test
    public void test_getTarget()
    {
        fail("This method cannot be tested because of the Scanner inside");
    }
    
    /**
     * Test setResult with various values to check
     * if proper messages are returned to the user
     */
    @Test
    public void test_setResult1()
    {
        p.setResult(true, true);
        assertTrue(output.toString().contains("missile has hit"));
    }
    
    /**
     * Test setResult with various values to check
     * if proper messages are returned to the user
     */
    @Test
    public void test_setResult2()
    {        
        p.setResult(true, true);
        assertTrue(output.toString().contains("sunk an enemy"));
        
        p.setResult(true, false);
        assertTrue(output.toString().contains("sunk an enemy"));
    }
    
    /**
     * Test setResult with various values to check
     * if proper messages are returned to the user
     */
    @Test
    public void test_setResult3()
    {
        p.setResult(false, false);
        assertTrue(output.toString().contains("missile missed"));
    }
    
    /**
     * Test the horizontal dimentions of the board
     * which is defined in the code as 10x10
     */
    @Test
    public void test_getBoard()
    {
        int[][] a = p.getBoard();
        assertEquals(a.length, 10);
    }
    
    /**
     * Test the vertical dimentions of the board
     * which is defined in the code as 10x10
     */
    @Test
    public void test_getBoard1()
    {
        int[][] a = p.getBoard();
        assertNotNull(a[0].length);
        assertEquals(a[0].length, 10);
    }

    /**
     * isValid method is used during the ship placement
     * it should return false when called after sucessfully
     * placed ship on the board
     */
    @Test
    public void test_isValid()
    {
    	p1.placeShip(4, true);
    	assertFalse(p1.isValid());
    }
    
    /**
     * This method cannot be tested because of the
     * Scanner inside it. Insted the mocked object
     * returns the location
     */
    @Test
    public void test_placeShip()
    {
    	Location loc = p1.placeShip(1, true);
    	assertEquals(loc.getX(), 4);
    	assertEquals(loc.getY(), 6);
    }
}