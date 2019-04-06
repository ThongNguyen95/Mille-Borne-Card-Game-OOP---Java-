/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards.Remedies;

import Cards.Card;
import Game.Player;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
//Remedy card
public class Roll implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        //Only accept Roll card if the top of Battle Area has one of these cards
        if (player.checkBattle("None") || player.checkBattle("Repairs")
                || player.checkBattle("Gasoline") || player.checkBattle("Spare Tire")
                || player.checkBattle("Stop")) {
            //set Battle Area to "Roll"
            player.setBattle("Roll");
            return true;
        } else {
            System.out.println("Can't play this Roll card. Try different cards.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "Roll";
    }
}
