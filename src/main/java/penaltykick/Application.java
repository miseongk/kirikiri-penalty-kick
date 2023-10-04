package penaltykick;


import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new OutputView(),new InputView());
        game.run();
    }
}
