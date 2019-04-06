/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.GameScenarios;

import Cards.Card;
import Cards.Distance.Distance;
import Cards.Hazards.OutofGas;
import Cards.Remedies.Gasoline;
import Cards.Remedies.SpareTire;
import Cards.Safeties.FuelTank;
import static Game.Console.STDIN;
import Game.Player;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thong Nguyen
 */
public class ScenarioFour implements BaseGame {

    private boolean gameOver;   //Keep track of game state
    private final ArrayDeque<Card> deck; //stack of cards, representing the deck
    private final ArrayList<Player> players; //List of players
    private int currentPlayer;  //keep track of current player
    private final int goal;   //Destination
    private Player winner;  //Keep track of the winner
    private final List<Player> winners;

    //Constructor
    public ScenarioFour() {
        deck = new ArrayDeque<>();
        players = new ArrayList<>();
        winners = new ArrayList<>();
        currentPlayer = 0;
        goal = 250; //Destination = 250km
        gameOver = false;
        //Add 2 players as default (can add more players later)
        for (int i = 0; i < 2; i++) {
            String name = "Player ";
            name = name.concat(String.valueOf(i + 1));
            players.add(new Player(name, goal));
        }
    }

    // Getter for Player
    public Player getPlayer(int number) {
        if (number < players.size()) {
            return players.get(number);
        } else {
            return players.get(0);
        }
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameover() {
        return gameOver;
    }

    //Initialize the deck
    @Override
    public void init() {
        //Add cards to a list
        for (int i = 0; i < 2; i++) {
            deck.add(new Distance(200));
        }
        deck.add(new OutofGas());
        deck.add(new SpareTire());
        for (int i = 0; i < 2; i++) {
            deck.add(new Distance(100));
        }
        deck.add(new Distance(200));
        deck.add(new Distance(100));
        deck.add(new Distance(200));
        deck.add(new FuelTank());
        deck.add(new Distance(100));
        deck.add(new Distance(25));
        deck.add(new Gasoline());
        deck.add(new Distance(200));
        for (int i = 0; i < 2; i++) {
            deck.add(new Distance(75));
        }
        deck.add(new Distance(100));
        //Distribute 6 cards to each player
        System.out.println("Dealing 6 cards to each player...\n");
        for (int i = 0; i < 6; i++) {
            players.get(0).draw(deck.removeFirst());
            players.get(1).draw(deck.removeFirst());
        }
        //Set Roll active for player 2, according to the scenario
        players.get(1).makeReady();
    }

    //Set current player. For JUnit testing
    public void setCurrentPlayer(int playerIndex) {
        currentPlayer = playerIndex;
    }
    
    // Apply the card effect to the current player
    public boolean play(Card _card) {
        // Check if the card is successfully played
        boolean played = _card.execute(players, currentPlayer);
        return played;
    }

    // Simulate each round of the game
    @Override
    public void execute() {
        if (!gameOver) {
            // Get the current player variables and also list of the cards on their 
            // hands
            Player player = players.get(currentPlayer);
            ArrayList<Card> hand = player.getHand();
            System.out.println("Turn: " + player + "\n*******************");

            //Draw a new card from the deck
            System.out.println("Drawing a card...");
            if (!deck.isEmpty() && (hand.size() < 7)) {
                player.draw(deck.removeFirst());
            }

            /// Show current status
            //Display distance traveled
            System.out.println("***Tableau***");
            System.out.println("Battle area: " + player.getBattle());
            System.out.println("Speed area: " + player.getSpeed());
            System.out.println("Safety area: ");
            player.displaySafeties();
            System.out.println("Distance traveled: " + player.getTraveled()
                    + " km");

            //Display the cards on-hand
            System.out.println("\nCards on hand:");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println(i + ". " + hand.get(i));
            }
            System.out.print("Pick a card to play or discard: ");
            int cardNumber = STDIN.nextInt();

            //Choose whether to play or discard the selected card
            System.out.print("1. Play\n2. Discard\nSelect your option: ");
            int option = STDIN.nextInt();
            //Execute the options
            boolean success = true; //temp variable use to update currentPlayer
            if (option == 1) {
                //Play the chosen card
                if (this.play(hand.get(cardNumber))) {
                    //Remove card from hand after playing, display it
                    System.out.println("Done! You played "
                            + hand.remove(cardNumber) + ".");
                    // If Safety was played. Draw and play another card
                    if (player.getRepeat()) {
                        System.out.println("Safety let you draw and play "
                                + "another card.");
                    }
                } else {
                    success = false;
                }
            } else {
                //Discard and Display
                System.out.println("Done! You discarded "
                        + hand.remove(cardNumber) + ".");
            }
            //Leave some space between each round
            System.out.println("\n");

            //Check if the game is over
            checkGameEnd(player);

            /*Update current Player after finishing the current turn*/
            //Use modular to get back to the first player after the last 
            //player is done with their turn
            if (success && !player.getRepeat()) {
                //only switch turn if current player successfully make their move
                currentPlayer = (currentPlayer + 1) % players.size();
            }
            //Set repeat back to false
            if (player.getRepeat()) {
                player.setRepeat(false);
            }

        } else {    //If game is over
            System.out.println("The game is over!");
            //If only 1 winner
            if (winners.size() < 2) {
                System.out.println("Winner:" + winner);
            } //If some players are tied
            else {
                for (Player cWinner : winners) {
                    System.out.print(cWinner + " ");
                }
                System.out.println("are tied.");
            }
            System.out.println("Distant traveled: " + winner.getTraveled()
                    + " km");
            System.exit(0);
        }
    }

    // Set gameOver flag and winner when the game end
    public void checkGameEnd(Player player) {
        if (!gameOver && player.getTraveled() == goal) {
            gameOver = true;
            winner = player;
        }
        //Check for deck out
        if (!gameOver && deck.isEmpty()) {
            System.out.println("Out of cards!");
            gameOver = true;
            //Look for winner with the longest distant traveled
            winner = players.get(0);
            int highestScore = players.get(0).getTraveled();
            for (int i = 1; i < players.size(); i++) {
                int tempScore = players.get(i).getTraveled();
                if (tempScore > highestScore) {
                    highestScore = tempScore;
                    winner = players.get(i);
                }
            }
            //Check if tie, add all the winners to the list
            winners.add(winner);
            int winnerScore = winner.getTraveled();
            for (Player cPlayer : players) {
                int tempScore = cPlayer.getTraveled();
                if (tempScore == winnerScore && cPlayer != winner) {
                    winners.add(cPlayer);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Scenario 4: Use Safety Card (Fuel Tank) to fix Out of Gas.";
    }
}
