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
// Remedy Card
public class Gasoline implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        // Can only play this card on top of an Out of Gas card to fix it
        if (player.checkBattle("Out of Gas")) {
            //Player can go right away if Right of Way safety card was played
            if (player.checkSafeties("Right of Way")) {
                player.setBattle("Roll");
            } else {
                player.setBattle("Repairs");
            }
            return true;
        } else {
            System.out.println("Can't play Gasoline. Try again.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "Gasoline";
    }
}
