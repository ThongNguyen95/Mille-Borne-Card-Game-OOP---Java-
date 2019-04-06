/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Cards.Card;
import java.util.ArrayList;

/**
 *
 * @author Thong Nguyen
 */
public class Player {

    private final String name;
    private final ArrayList<Card> hand; //The current cards on-hand
    private final int goal;
    private boolean repeat; // To replay when Safety card is played
    //tableau areas
    private int traveled;  // Miles travelled
    private String battle;  // Area for Hazard and Remedies
    private String speed; // Area for Speed Limit and End of Limit
    private final ArrayList<String> safeties; //List of safeties on this player

    public Player(String _name, int _goal) {
        name = _name;
        traveled = 0;
        hand = new ArrayList<>();
        goal = _goal;
        battle = "None";
        speed = "None";
        safeties = new ArrayList<>();
        repeat = false;
    }

    // Draw new card to your hand from the deck
    public void draw(Card _card) {
        hand.add(_card);
    }

    //Getters
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getTraveled() {
        return traveled;
    }

    //Not used in actual application, for testing purpose
    public void setTraveled(int _mileage) {
        traveled = _mileage;
    }

    //Check for values
    public boolean canGo() {
        return battle.equals("Roll");
    }

    //Return current value of Speed area
    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String _speed) {
        speed = _speed;
    }

    public boolean checkSpeed(String _speed) {
        return speed.equals(_speed);
    }

    //Check if player have the safeties card played
    public boolean checkSafeties(String _safety) {
        for (String safety : safeties) {
            if (safety.equals(_safety)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSafeties(String _safety) {
        return safeties.add(_safety);
    }

    public void displaySafeties() {
        for (String safety : safeties) {
            System.out.println("\t-" + safety);
        }
    }

    //These are methods to modify the current effects placed on player
    public String getBattle() {
        return battle;
    }

    public void setBattle(String _battle) {
        battle = _battle;
    }

    public boolean checkBattle(String _battle) {
        return battle.equals(_battle);
    }

    // Allow player to go after a Go card is played, mainly used for scenario
    // testing, JUnit tests
    public void makeReady() {
        battle = "Roll";
    }

    public boolean getRepeat() {
        return repeat;
    }

    public void setRepeat(boolean _repeat) {
        repeat = _repeat;
    }

    //Check to make sure the player does not travel past the destination
    public boolean checkTraveled(int distant) {
        return (traveled + distant <= goal);
    }

    // Add to the distant traveled
    public void addTraveled(int _miles) {
        traveled += _miles;
    }

    //Show player's name
    @Override
    public String toString() {
        return name;
    }
}
