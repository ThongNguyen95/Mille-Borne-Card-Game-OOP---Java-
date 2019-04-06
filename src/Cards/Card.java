/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*Cards needed:
Hazards:
Remedies:
Safeties:
    Puncture Proof:1

 */
package Cards;

import Game.Player;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
//Interface for all the card types
public interface Card {

    public boolean execute(ArrayList<Player> players, int currentPlayer);
}
