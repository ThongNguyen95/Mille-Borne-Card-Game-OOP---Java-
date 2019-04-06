/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards.Hazards;

import Cards.Card;
import static Game.Console.STDIN;
import Game.Player;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
// Hazard card
public class Stop implements Card {

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player target;
        if (players.size() < 3) {   //No need to pick target if there're only 2 players
            target = players.get((currentPlayer + 1) % players.size());
        } else {    // Pick the target for the card
            System.out.println("Choose the target player for this card:");
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i) != players.get(currentPlayer)) {
                    System.out.println(i + ". " + players.get(i));
                }
            }
            System.out.print("Target: ");
            int targetIndex = STDIN.nextInt();
            target = players.get(targetIndex);
        }
        // Can be placed when the Battle Area is not empty
        if (!target.checkBattle("None")) {
            //Nested if statement to discard the Hazard if it is played against
            // a Safety card
            if (!target.checkSafeties("Right of Way")) {
                target.setBattle("Stop");
            } else {
                System.out.println("Player is protected by Right of Way."
                        + " Discarding the card!");
            }
            return true;
        } else {
            System.out.println("Can't play Stop. Try different cards");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        return "Stop";
    }
}
