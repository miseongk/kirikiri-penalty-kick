package penaltykick.controller;

import penaltykick.model.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class PenaltykickController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        outputView.printStartGame();
        Player player1 = new Player(inputView.inputNumberPlayer1());
        Player player2 = new Player(inputView.inputNumberPlayer2());
    }
}
