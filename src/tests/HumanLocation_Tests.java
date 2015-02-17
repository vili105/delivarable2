package tests;

import org.junit.*;

import battleship.HumanLocation;
import static org.junit.Assert.*;

public class HumanLocation_Tests
{
    HumanLocation l;
    
    /**
     * Setup by initializing a HumanLocation object
     * with a vertical ship at position 1000, 2000
     * with size of 8 units
     */
    @Before
    public void setUp()
    {
        l = new HumanLocation(1000, 2000, false, 8);
    }
    
    /**
     * Test if the position on X is identical to the initialized
     */
    @Test
    public void test_getX()
    {
        assertTrue(l.getX() == 1000);
    }
    
    /**
     * Test if the position on Y is identical to the initialized
     */
    @Test
    public void test_getY()
    {
        assertTrue(l.getY() == 2000);
    }
    
    /**
     * Test if the orientation of the ship is identical to the initialized
     */
    @Test
    public void test_isShipHorizontal()
    {
        assertFalse(l.isShipHorizontal());
    }
    
    /**
     * Test if the size of the ship is identical to the initialized
     */
    @Test
    public void test_getShipSize()
    {
        assertTrue(l.getShipSize() == 8);
    }
}