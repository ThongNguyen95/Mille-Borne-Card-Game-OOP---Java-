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
//Remedy Card
public class EndSpdLimit implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        // If speed is currently limited, turn off the limit
        if (player.checkSpeed("Speed Limit")) {
            player.setSpeed("End of Speed Limit"); // Remove the speed limit
            return true;
        } else {
            System.out.println("Can't play End of Speed Limit. Try again.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "End of Speed Limit";
    }
}
