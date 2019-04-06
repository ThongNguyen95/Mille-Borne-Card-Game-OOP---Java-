 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Cards.Distance.Distance;
import Cards.Hazards.FlatTire;
import Cards.Remedies.Roll;
import Cards.Remedies.SpareTire;
import Game.GameScenarios.ScenarioThree;
import Game.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thong Nguyen
 */
//Test if functions for scenario #3 (Hazard card and Remedy card) works properly
public class ScenarioThreeTest {
    
    private ScenarioThree scenario;
    private Player player1, player2;
    public ScenarioThreeTest() {
    }
    
    @Before
    public void setUp() {
        scenario = new ScenarioThree();
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
    //Try Remedy Card (Spare Tire) to counter Hazard Card (Flat Tire)
    @Test
    public void tryHazardRemedyCards() {
        //Set current player to player 1
        scenario.setCurrentPlayer(0);
        //Play Flat Tire on Player 2
        scenario.play(new FlatTire());
        //Check if the top card on the Battle area of player 2 is Flat Tire
        assertTrue(player2.checkBattle("Flat Tire"));
        //Player 2 uses Spare Tire card, 
        // test if the Battle area of player 2 is Spare Tire
        scenario.setCurrentPlayer(1);
        scenario.play(new SpareTire());
        assertTrue(player2.checkBattle("Spare Tire"));
        
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
