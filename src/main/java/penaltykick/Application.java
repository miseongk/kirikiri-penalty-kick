package penaltykick;


import penaltykick.controller.GameController;
import penaltykick.utill.Validation;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Validation validation = new Validation();
        GameController game = new GameController(outputView, inputView, validation);
        game.run();
    }
}
