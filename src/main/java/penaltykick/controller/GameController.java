package penaltykick.controller;

import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
