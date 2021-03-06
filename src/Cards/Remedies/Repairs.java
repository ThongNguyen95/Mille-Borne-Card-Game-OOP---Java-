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
public class Repairs implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        // Can only play this card on top of an Accident card to fix it
        if (player.checkBattle("Accident")) {
            //Player can go right away if Right of Way safety card was played
            if (player.checkSafeties("Right of Way")) {
                player.setBattle("Roll");
            } else {
                player.setBattle("Repairs");
            }
            return true;
        } else {
            System.out.println("Can't play Repairs. Try again.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "Repairs";
    }
}
