package penaltykick;


import penaltykick.Utill.Validation;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView =OutputView.getInstance();
        InputView inputView = InputView.getInstance();
        Validation validation = Validation.getInstance();
        Game game = new Game(outputView,inputView,validation);
        game.run();
    }
}
