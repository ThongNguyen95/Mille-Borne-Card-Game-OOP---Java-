/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Game.GameScenarios.ScenarioTwo;
import Game.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thong Nguyen
 */

//Test if functions for scenario #2 (deck out of cards) works properly
public class ScenarioTwoTest {
    private ScenarioTwo scenario;
    private Player player1, player2;
    public ScenarioTwoTest() {
    }
    
    @Before
    public void setUp() {
        scenario = new ScenarioTwo();
        //Initialize the scenario
        scenario.init();
        player1 = scenario.getPlayer(0);
        player2 = scenario.getPlayer(1);
    }
    
    //Test if each player has 6 cards on hand at the beginning of the scenario
    // to make sure scenario.init() works properly
    @Test
    public void cardOnHand() {
        assertEquals(6, player1.getHand().size());
        assertEquals(6, player2.getHand().size());
    }
    //Test if the scenario where the game ends because of deck-out works properly.
    @Test
    public void checkDeckOut() {
        //Test if the deck currently has 2 cards
        assertEquals(2, scenario.getDeck().size());
        // Each player draws 1 card
        player1.draw(scenario.getDeck().removeFirst());
        player2.draw(scenario.getDeck().removeFirst());
        //Test if the deck is empty
        assertEquals(0, scenario.getDeck().size());
    }
    
    //Test game over because of deckout and correct winner is player 2 (200 km)
    @Test
    public void testGameEndAndWinner() {
        //Set current player to player 1
        player1.draw(scenario.getDeck().removeFirst());
        player2.draw(scenario.getDeck().removeFirst());
        scenario.checkGameEnd(player1);
        //Test if game is over
        assertTrue(scenario.isGameover());
        // Test for winner
        assertEquals(player2, scenario.getWinner());
    }
}
