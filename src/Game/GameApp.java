/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.GameScenarios.Game;
import Game.GameScenarios.ScenarioFour;
import Game.GameScenarios.ScenarioMenu;
import Game.GameScenarios.ScenarioOne;
import Game.GameScenarios.ScenarioThree;
import Game.GameScenarios.ScenarioTwo;

/**
 *
 * @author Thong Nguyen
 * 
 
@Expected Outputs (except Randomized behavior option): These scenarios are exactly 
the same as Homework 1. I only added some new features like displaying the tableau
areas and showing what the player has played.
 
@Scenario 1: Play a Stop card on top of a Roll card. 

Dealing 6 cards to each player...

Turn: Player 1
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Roll
2. Mileage 100
3. Mileage 200
4. Mileage 200
5. Spare Tire
6. Mileage 100
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Roll.


Turn: Player 2
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Stop
2. Mileage 100
3. Mileage 100
4. Gasoline
5. Mileage 25
6. Mileage 200
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Stop.


Turn: Player 1
*******************
Drawing a card...
***Tableau***
Battle area: Stop
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Mileage 100
2. Mileage 200
3. Mileage 200
4. Spare Tire
5. Mileage 100
6. Mileage 75
Pick a card to play or discard: 


@Scenario 2: When the deck is out of cards.

Turn: Player 1
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
Distance traveled: 150 km

Cards on hand:
0. Mileage 200
1. Roll
2. Mileage 100
3. Mileage 200
4. Mileage 200
5. Spare Tire
6. Mileage 100
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Roll.


Turn: Player 2
*******************
Drawing a card...
***Tableau***
Battle area: Roll
Speed area: None
Safety area: 
Distance traveled: 200 km

Cards on hand:
0. Mileage 200
1. Stop
2. Mileage 100
3. Mileage 100
4. Gasoline
5. Mileage 25
6. Mileage 200
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Stop.


Out of cards!
The game is over!
Winner:Player 2
Distant traveled: 200 km


@Scenario 3: Player 1 plays Flat Tire (player 2 already has Roll), Player 2 
plays Spare Tire to fix it.

Turn: Player 1
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Roll
2. Mileage 100
3. Mileage 200
4. Mileage 200
5. Flat Tire
6. Mileage 100
Pick a card to play or discard: 5
1. Play
2. Discard
Select your option: 1
Done! You played Flat Tire.


Turn: Player 2
*******************
Drawing a card...
***Tableau***
Battle area: Flat Tire
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Spare Tire
2. Mileage 100
3. Mileage 100
4. Gasoline
5. Mileage 25
6. Mileage 200
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Spare Tire.


Turn: Player 1
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Roll
2. Mileage 100
3. Mileage 200
4. Mileage 200
5. Mileage 100
6. Gasoline
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Roll.


Turn: Player 2
*******************
Drawing a card...
***Tableau***
Battle area: Spare Tire
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Mileage 100
2. Mileage 100
3. Gasoline
4. Mileage 25
5. Mileage 200
6. Mileage 75
Pick a card to play or discard: 


@Scenario 4: Player 1 plays Out of Gas (player 2 already has Roll), Player 2
counter it with a Safety card (Fuel Tank).

Turn: Player 1
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Out of Gas
2. Mileage 100
3. Mileage 200
4. Mileage 200
5. Mileage 100
6. Gasoline
Pick a card to play or discard: 1
1. Play
2. Discard
Select your option: 1
Done! You played Out of Gas.


Turn: Player 2
*******************
Drawing a card...
***Tableau***
Battle area: Out of Gas
Speed area: None
Safety area: 
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Spare Tire
2. Mileage 100
3. Mileage 100
4. Fuel Tank
5. Mileage 25
6. Mileage 200
Pick a card to play or discard: 4
1. Play
2. Discard
Select your option: 1
Done! You played Fuel Tank.
Safety let you draw and play another card.


Turn: Player 2
*******************
Drawing a card...
***Tableau***
Battle area: None
Speed area: None
Safety area: 
	-Fuel Tank
Distance traveled: 0 km

Cards on hand:
0. Mileage 200
1. Spare Tire
2. Mileage 100
3. Mileage 100
4. Mileage 25
5. Mileage 200
6. Mileage 75
Pick a card to play or discard: 
 */
public class GameApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialize the scenarios and menu
        ScenarioMenu menu = new ScenarioMenu();
        //Add scenarios to the menu
        menu.addScenario(new Game());
        menu.addScenario(new ScenarioOne());
        menu.addScenario(new ScenarioTwo());
        menu.addScenario(new ScenarioThree());
        menu.addScenario(new ScenarioFour());
        System.out.println("Mille Bornes. ver 1.0\n");
        //Run the scenarios menu to let the user pick the scenarios
        menu.execute();

    }

}
