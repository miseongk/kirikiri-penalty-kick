package penaltykick.controller;

import penaltykick.domain.Goalkeeper;
import penaltykick.domain.Player;
import penaltykick.domain.Referee;
import penaltykick.dto.Result;

import java.util.Scanner;

public class GameController {

    private final String PLAYER1 = "플레이어1";
    private final String PLAYER2 = "플레이어2";

    private Scanner sc;
    private Player player1;
    private Player player2;
    private Goalkeeper goalKeeper;
    private Referee referee;



    public GameController(Scanner scanner) {
        sc = scanner;
        goalKeeper = new Goalkeeper();
        player1 = new Player(PLAYER1);
        player2 = new Player(PLAYER2);
        referee = new Referee();
    }

    public void play() {
        startGame();
        askNumber();
        endGame();
    }


    public void startGame() {
        referee.notifyStartGame();
    }

    public void askNumber() {
        goalKeeper.generateNumbers();

        referee.notifyAskNumbers(player1.getName());
        String player1Numbers = sc.nextLine();
        player1.generateNumbers(player1Numbers);

        referee.notifyAskNumbers(player2.getName());
        String player2Numbers = sc.nextLine();
        player2.generateNumbers(player2Numbers);
    }

    public void endGame() {
        Result player1Result = referee.decideGoalOrNot(goalKeeper.getNumbers(), player1.getNumbers(), player1.getName());
        Result player2Result = referee.decideGoalOrNot(goalKeeper.getNumbers(), player2.getNumbers(), player2.getName());
        Result gameResult = referee.decideWinner(player1Result, player2Result);
        referee.notifyGameResult(gameResult);
    }
}
