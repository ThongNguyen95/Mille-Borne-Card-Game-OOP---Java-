/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Cards.Distance.Distance;
import Cards.Hazards.Stop;
import Cards.Remedies.Roll;
import Game.GameScenarios.ScenarioOne;
import Game.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thong Nguyen
 */

//Test if functions for scenario #1 (the use of Stop card) works properly
public class ScenarioOneTest {
    private ScenarioOne scenario;
    private Player player1, player2;
    public ScenarioOneTest() {
    }
    
    @Before
    public void setUp() {
        scenario = new ScenarioOne();
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
    //Try Stop card to stop other player's Roll card
    @Test
    public void tryStopCard() {
        //Set current player to player 1
        scenario.setCurrentPlayer(0);
        scenario.play(new Roll());
        //Check if the top card on the Battle area of player 1 is Roll
        assertTrue(player1.checkBattle("Roll"));
        //Player 2 uses Stop card, test if the Battle area of player 1 is Stop
        scenario.setCurrentPlayer(1);
        scenario.play(new Stop());
        assertTrue(player1.checkBattle("Stop"));
        
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
