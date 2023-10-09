package penaltykick.config;

import penaltykick.controller.GameController;
import penaltykick.domain.Goalkeeper;
import penaltykick.domain.Player;
import penaltykick.domain.Referee;
import penaltykick.util.GenerateRandom;

import java.util.ArrayList;
import java.util.Scanner;

public class GameConfig {

    private GameController controller;

    public GameConfig() {
        Goalkeeper goalkeeper = new Goalkeeper(new GenerateRandom(), new ArrayList<Integer>());
        Player player1 = new Player("플레이어1", new ArrayList<Integer>());
        Player player2 = new Player("플레이어2", new ArrayList<Integer>());
        Referee referee = new Referee();
        Scanner scanner = new Scanner(System.in);
        controller = new GameController(scanner, goalkeeper, player1, player2, referee);
    }

    public void gameStart() {
        controller.play();
    }
}
