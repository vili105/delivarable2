package tests;

import org.junit.*;

import battleship.ComputerLocation;
import static org.junit.Assert.*;

public class ComputerLocation_Tests
{
    ComputerLocation l;
    
    /**
     * Setup by initializing a ComputerLocation object
     * with a horizontal ship at position 100, 200
     * with size of 4 units
     */
    @Before
    public void setUp()
    {
        l = new ComputerLocation(100, 200, true, 4);
    }
    
    @Test
    public void test_getX()
    {
        assertEquals(l.getX(), 100);
    }
    
    @Test
    public void test_getY()
    {
        assertEquals(l.getY(), 200);
    }
    
    @Test
    public void test_isShipHorizontal()
    {
        assertTrue(l.isShipHorizontal());
    }
    
    @Test
    public void test_getShipSize()
    {
        assertEquals(l.getShipSize(), 4);
    }
}