package tests;

import org.junit.*;

import battleship.BattleShipGame;
import battleship.ComputerPlayer;
import battleship.Game;
import battleship.Player;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BattleShipGame_Tests
{
    ComputerPlayer p1;
    ComputerPlayer p2;
    Game game;
    
    ByteArrayOutputStream output;
    ByteArrayOutputStream errors;
    
    /**
     * Setup a new game with 2 computer players
     * Human players cannot be tested because they rely
     * on the user input via Scanner
     *
     * Set the standard output to a variable
     * Redirect all errors to a variable
     */
    @Before
    public void setUp()
    {
        p1 = new ComputerPlayer();
        p2 = new ComputerPlayer();
        
        game = new BattleShipGame();
        
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
     * Test the game initialization
     * It should deply the ships for the 2 players
     */
    @Test
    public void test_initShipDeploy()
    {
        game.initialize(p1, p2);
        
        assertTrue(output.toString().contains("Deploying ships for Player 1"));
        assertTrue(output.toString().contains("Deploying ships for Player 2"));
    }
    
    /**
     * Test the actual gameplay
     * It should contain a notification of a fired missile
     * on of the ships must sink
     * and the other one must won the game
     *
     * The winning player should not be null
     */
    @Test
    public void test_playGame()
    {        
        game.initialize(p1, p2);
        Player player_won = game.playGame();
        
        assertTrue(output.toString().contains("firing a missile"));
        assertTrue(output.toString().contains("sunk"));
        assertTrue(output.toString().contains("won"));
        assertNotNull(player_won);
    }
    
    /**
     * This method cannot be tested because it relies on
     * many private variables that cannot be set
     */
    @Test
    public void test_getBoard()
    {
        fail("This method cannot be tested");
    }
    
    /**
     * This method cannot be tested because it relies on
     * many private variables that cannot be set
     */
    @Test
    public void test_getSunkFor()
    {
        fail("This method cannot be tested");
    }
}