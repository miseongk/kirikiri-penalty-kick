package penaltykick.controller;

import penaltykick.model.Player;
import penaltykick.model.Game;
import penaltykick.service.PenaltykickService;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

import java.util.List;

public class PenaltykickController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        outputView.printStartGame();
        outputView.printInputFiveNumber();
        try {
            Player player1 = initPlayer1();
            Player player2 = initPlayer2();
            Game game = initGame();
            comparePlayer(player1, player2, game);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startProgram();
        }
    }

    public Player initPlayer1() {
        try {
            return new Player(inputView.inputNumberPlayer1());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayer1();
        }
    }

    public Player initPlayer2() {
        try {
            return new Player(inputView.inputNumberPlayer2());
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayer2();
        }
    }

    public Game initGame() {
        return new Game(PenaltykickService.makeRandomNumberList());
    }

    public void comparePlayer(Player player1, Player player2, Game game) {
        compareEachPlayer(player1, game);
        compareEachPlayer(player2, game);
        printResult(player1, player2);
    }

    public void compareEachPlayer(Player player, Game game) {
        player.initResultValue(
            game.makeResultString(player.getNumberList()));
    }

    public void printResult(Player player1, Player player2) {
        outputView.printGameResult();
        outputView.printPlayer1Result(player1.getResultString());
        outputView.printPlayer2Result(player2.getResultString());
        printWinner(player1, player2);
    }

    public void printWinner(Player player1, Player player2) {
        int player1Result = player1.getSuccessNumber();
        int player2Result = player2.getSuccessNumber();

        if (player1Result > player2Result) {
            outputView.printResultPlayer1Win();
        }

        if (player1Result < player2Result) {
            outputView.printResultPlayer2Win();
        }

        if (player1Result == player2Result) {
            outputView.printResultDraw();
        }
    }
}

