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
public class RightofWay implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        //Add the safety to the Safeties list
        if (player.addSafeties("Right of Way")) {
            //Fix the Stop and Speed Limit if it exists
            if (player.checkBattle("Stop") || player.checkBattle("None")) {
                System.out.println("Right of Way activated Roll.");
                player.setBattle("Roll");
            }
            if (player.checkSpeed("Speed Limit")) {
                player.setSpeed("None");
            }
            player.setRepeat(true);
            return true;
        } else {
            System.out.println("Can't play Right of Way. Try again.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "Right of Way";
    }
}
