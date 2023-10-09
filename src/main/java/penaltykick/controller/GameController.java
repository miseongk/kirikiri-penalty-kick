package penaltykick.controller;

import penaltykick.domain.Goalkeeper;
import penaltykick.domain.Player;
import penaltykick.domain.Referee;
import penaltykick.dto.GameResult;
import penaltykick.dto.PlayerResult;

import java.util.Scanner;

public class GameController {

    private final String PLAYER1 = "플레이어1";
    private final String PLAYER2 = "플레이어2";

    private Scanner sc;
    private Player gamePlayer1;
    private Player gamePlayer2;
    private Goalkeeper gameGoalkeeper;
    private Referee gameReferee;


    public GameController() {

    }

    public GameController(Scanner scanner, Goalkeeper goalKeeper, Player player1, Player player2, Referee referee) {
        sc = scanner;
        gameGoalkeeper = goalKeeper;
        gamePlayer1 = player1;
        gamePlayer2 = player2;
        gameReferee = referee;
    }

    public void play() {
        startGame();
        askNumber();
        endGame();
    }


    public void startGame() {
        gameReferee.notifyStartGame();
    }

    public void askNumber() {
        gameGoalkeeper.generateNumbers();

        gameReferee.notifyAskNumbers(gamePlayer1.getName());
        String player1Numbers = sc.nextLine();
        gamePlayer1.generateNumbers(player1Numbers);

        gameReferee.notifyAskNumbers(gamePlayer2.getName());
        String player2Numbers = sc.nextLine();
        gamePlayer2.generateNumbers(player2Numbers);
    }

    public void endGame() {
        PlayerResult player1Result = gameReferee.generatePlayerResult(gameGoalkeeper.getNumbers(), gamePlayer1.getNumbers(), new PlayerResult(gamePlayer1.getName()));
        PlayerResult player2Result = gameReferee.generatePlayerResult(gameGoalkeeper.getNumbers(), gamePlayer2.getNumbers(), new PlayerResult(gamePlayer2.getName()));
        GameResult gameResult = gameReferee.decideWinner(player1Result, player2Result);
        gameReferee.notifyGameResult(gameResult);
    }
}
