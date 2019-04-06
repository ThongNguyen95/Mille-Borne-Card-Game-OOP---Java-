/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.GameScenarios;

import static Game.Console.STDIN;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thong Nguyen
 */
//Choose the scenarios to test 
public class ScenarioMenu {

    private final List<BaseGame> scenarios;

    public ScenarioMenu() {
        scenarios = new ArrayList<>();
    }

    public void addScenario(BaseGame _scenario) {
        scenarios.add(_scenario);
    }

    public void execute() {
        //Display and pick the scenarios to run
        System.out.println("List of Scenarios:");
        for (int i = 0; i < scenarios.size(); i++) {
            System.out.println(i + ". " + scenarios.get(i));
        }
        System.out.print("Choose a scenario: ");
        int option = STDIN.nextInt();
        System.out.println();
        BaseGame scenario = scenarios.get(option);

        //Run the scenario
        scenario.init();
        while (true) {
            scenario.execute();
        }
    }
}
