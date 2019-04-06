/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards.Distance;

import Cards.Card;
import Game.Player;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
//Distance Card
public class Distance implements Card {

    private final int mileage;

    public Distance(int _milleage) {
        mileage = _milleage;
    }

    @Override
    public boolean execute(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        //Check to make sure Roll is activated and player would not go over
        // the destination before applying the change
        if (player.checkBattle("Roll") && player.checkTraveled(mileage)) {
            // Check if speed is limited and mileage greater than 50
            if (player.checkSpeed("Speed Limit") && mileage > 50) {
                System.out.println("Warning! Your speed is limited to under "
                        + "50 miles. Try again.");
                return false;
            } else {
                player.addTraveled(mileage);
                return true;
            }
        } else {
            System.out.println("Can't play this mileage card. Try different cards.");
            return false;
        }
    }

    // Overload the card name
    @Override
    public String toString() {
        String temp = "Mileage ";
        temp = temp.concat(String.valueOf(mileage));
        return temp;
    }
}
