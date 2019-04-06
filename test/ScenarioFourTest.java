/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Cards.Distance.Distance;
import Cards.Hazards.OutofGas;
import Cards.Remedies.Roll;
import Cards.Safeties.FuelTank;
import Game.GameScenarios.ScenarioFour;
import Game.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thong Nguyen
 */
//Test if functions for scenario #4 (Hazard card and Safety card) works properly
public class ScenarioFourTest {
    
    private ScenarioFour scenario;
    private Player player1, player2;
    public ScenarioFourTest() {
    }
    
    @Before
    public void setUp() {
        scenario = new ScenarioFour();
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
    //Try Safety Card (Fuel Tank) to counter Hazard Card (Out of Gas)
    @Test
    public void tryHazardAndSafetyCard() {
        //Set current player to player 1
        scenario.setCurrentPlayer(0);
        //Play Out of Gas on Player 2
        scenario.play(new OutofGas());
        //Check if the top card on the Battle area of player 2 is Out of Gas
        assertTrue(player2.checkBattle("Out of Gas"));
        //Player 2 uses Fuel Tank card, 
        // test if Fuel Tank is in the Safeties cards list
        scenario.setCurrentPlayer(1);
        scenario.play(new FuelTank());
        assertTrue(player2.checkSafeties("Fuel Tank"));
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
