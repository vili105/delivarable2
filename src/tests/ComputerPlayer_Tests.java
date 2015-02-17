package tests;

import org.junit.*;

import battleship.ComputerLocation;
import battleship.ComputerPlayer;
import battleship.Location;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputerPlayer_Tests
{
    ComputerPlayer p;
    ComputerPlayer p1;
    
    ByteArrayOutputStream output;
    ByteArrayOutputStream errors;
    
    /**
     * Define a mocked ComputerPlayer object with location at position 1, 1
     * to override the behavior of the computer player
     * to place random ships on the board
     *
     * Set the standard output to a variable
     * Redirect all errors to a variable
     */
    @Before
    public void setUp()
    {
        p = mock(ComputerPlayer.class);
        p1 = new ComputerPlayer();
        
        ComputerLocation l = new ComputerLocation(1, 1, true, 4);
        when(p.placeShip(4, true)).thenReturn(l);
        when(p.isValid()).thenReturn(true);
        
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
     * Test the location of a ship placed on x = 1
     */
    @Test
    public void test_placeShip1()
    {
        Location loc = p.placeShip(4, true);
        assertEquals(loc.getX(), 1);
    }
    
    /**
     * Test the location of a ship placed on y = 1
     */
    @Test
    public void test_placeShip2()
    {
        Location loc = p.placeShip(4, true);
        assertEquals(loc.getY(), 1);
    }
    
    /**
     * Test the oriantation of a horizontally placed ship
     */
    @Test
    public void test_placeShip3()
    {
        Location loc = p.placeShip(4, true);
        assertTrue(loc.isShipHorizontal());
    }
    
    /**
     * Test the oriantation of a vertically placed ship
     */
    @Test
    public void test_placeVerticalShip()
    {
        ComputerPlayer p2 = mock(ComputerPlayer.class);
        
        ComputerLocation l = new ComputerLocation(1, 1, false, 4);
        when(p2.placeShip(4, true)).thenReturn(l);
        
        Location loc = p2.placeShip(4, true);
        
        assertFalse(loc.isShipHorizontal());
    }
    
    /**
     * Test the horizontal dimentions of the board
     * which is defined in the code as 10x10
     */
    @Test
    public void test_getBoard()
    {
        int[][] a = p1.getComputerBoard();
        assertEquals(a.length, 10);
    }
    
    /**
     * Test the vertical dimentions of the board
     * which is defined in the code as 10x10
     */
    @Test
    public void test_getBoard1()
    {
        int[][] a = p1.getComputerBoard();
        assertEquals(a[0].length, 10);
    }
    
    /**
     * This method returns a random ship on the board
     * and it should not return null values for its location
     */
    @Test
    public void test_getTarget()
    {
        Location loc = p1.getTarget();
        
        assertNotNull(loc.getX());
        assertNotNull(loc.getY());
    }
    
    /**
     * Test the lastHit method with different values
     */
    @Test
    public void test_lastHit1()
    {
        assertTrue(p1.lastHit(true, false));
    }
    
    /**
     * Test the lastHit method with different values
     */
    @Test
    public void test_lastHit2()
    {
        assertFalse(p1.lastHit(true, true));
    }
    
    /**
     * Test the lastHit method with different values
     */
    @Test
    public void test_lastHit3()
    {
        assertFalse(p1.lastHit(false, false));
    }
    
    /**
     * Test the lastHit method with different values
     */
    @Test
    public void test_lastHit4()
    {
        assertFalse(p1.lastHit(false, true));
    }
    
    /**
     * Test setResult with various values to check
     * if proper messages are returned to the user
     */
    @Test
    public void test_setResult1()
    {
        p1.setResult(true, true);
        assertTrue(output.toString().contains("missile has hit"));
    }
    
    /**
     * Test setResult with various values to check
     * if proper messages are returned to the user
     */
    @Test
    public void test_setResult2()
    {        
        p1.setResult(true, true);
        assertTrue(output.toString().contains("sunk an enemy"));
        
        p1.setResult(true, false);
        assertTrue(output.toString().contains("sunk an enemy"));
    }
    
    /**
     * Test setResult with various values to check
     * if proper messages are returned to the user
     */
    @Test
    public void test_setResult3()
    {
        p1.setResult(false, false);
        assertTrue(output.toString().contains("missile missed"));
    }
    
    @Test
    public void test_printComputerBoard()
    {
    	p1.printComputerBoard();
    	fail("This method cannot be tested");
    }
    
    /**
     * getTarget method will return the position of the aimed ship
     * It should contain actual coordinates
     */
    @Test
    public void test_getTarget()
    {
    	Location loc = p1.getTarget();
    	assertNotNull(loc.getX());
    	assertNotNull(loc.getY());
    }
    
    /**
     * isValid method is used during the ship placement
     * it should return false when called after sucessfully
     * placed ship on the board
     */
    @Test
    public void test_isValid()
    {
    	p1.placeShip(1, false);
    	assertFalse(p1.isValid());
    }
}