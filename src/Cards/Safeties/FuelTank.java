/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards.Safeties;

import Cards.Card;
import Game.Player;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
//Safety Card
public class FuelTank implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        //Add the safety to the Safeties list
        if (player.addSafeties("Fuel Tank")) {
            //Fix the hazard if it exists
            if (player.checkBattle("Out of Gas")) {
                //Player can go right away if Right of Way safety card was played
                if (player.checkSafeties("Right of Way")) {
                    player.setBattle("Roll");
                } else {
                    player.setBattle("None");
                }
            }
            player.setRepeat(true);
            return true;
        } else {
            System.out.println("Can't play Fuel Tank. Try again.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "Fuel Tank";
    }
}
