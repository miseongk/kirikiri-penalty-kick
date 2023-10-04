package penaltykick;


import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView =OutputView.getInstance();
        InputView inputView = InputView.getInstance();
        Game game = new Game(outputView,inputView);
        game.run();
    }
}
