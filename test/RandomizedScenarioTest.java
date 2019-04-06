/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Cards.Distance.Distance;
import Cards.Remedies.Roll;
import Game.GameScenarios.Game;
import Game.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thong Nguyen
 */

//Test if functions for randomized scenario works properly
public class RandomizedScenarioTest {
    
    private Game scenario;
    private Player player1, player2;
    
    public RandomizedScenarioTest() {
    }
    
    @Before
    public void setUp() {
        scenario = new Game();
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
    //Try mileage card after playing roll
    @Test
    public void tryMileageCard() {
        //Set current player to player 1
        scenario.setCurrentPlayer(0);
        scenario.play(new Roll());
        scenario.play(new Distance(200));
        assertEquals(200, player1.getTraveled());
    }
    
    //Test game over and correct winner
    @Test
    public void testGameEndAndWinner() {
        //Set current player to player 1
        scenario.setCurrentPlayer(0);
        scenario.play(new Roll());
        scenario.play(new Distance(250));
        scenario.checkGameEnd(player1);
        //Test if game is over
        assertTrue(scenario.isGameover());
        // Test for winner
        assertEquals(player1, scenario.getWinner());
    }
}
