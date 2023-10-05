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
    }

    public void compareEachPlayer(List<Integer> computerList, Player player) {
        player.initResultValue(PenaltykickService.makeResultString(computerList, player.getNumberList()));
    }
}
