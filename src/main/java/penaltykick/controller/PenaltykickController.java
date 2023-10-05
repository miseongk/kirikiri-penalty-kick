package penaltykick.controller;

import penaltykick.model.Player;
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
            Player player1 = new Player(inputView.inputNumberPlayer1());
            Player player2 = new Player(inputView.inputNumberPlayer2());
            comparePlayer(player1, player2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void comparePlayer(Player player1, Player player2) {
        List<Integer> computerList = PenaltykickService.makeRandomNumberList();
        compareEachPlayer(computerList, player1);
        compareEachPlayer(computerList, player2);
        printResult(player1, player2);
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

        if(player1Result > player2Result) {
            outputView.printResultPlayer1Win();
        }

        if(player1Result < player2Result) {
            outputView.printResultPlayer2Win();
        }

        if(player1Result == player2Result) {
            outputView.printResultDraw();
        }
    }

    public void compareEachPlayer(List<Integer> computerList, Player player) {
        player.initResultValue(PenaltykickService.makeResultString(computerList, player.getNumberList()));
    }
}

