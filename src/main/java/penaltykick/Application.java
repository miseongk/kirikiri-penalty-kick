package penaltykick;


import penaltykick.utill.Validation;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Validation validation = new Validation();
        Game game = new Game(outputView, inputView, validation);
        game.run();
    }
}
