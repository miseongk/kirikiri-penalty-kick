package penaltykick.controller;

import java.util.List;
import penaltykick.domain.ComputerPosition;
import penaltykick.domain.GameResult;
import penaltykick.domain.PlayerPosition;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class SoccerGameController {

    public SoccerGameController() {
        OutputView.printStartMessage();
    }

    public void playGame() {
        gameProcess();
    }

    private void gameProcess() {
        List<Integer> computerPosition = new ComputerPosition().getComputerPosition();

        List<Integer> playerOnePosition = createPlayerPosition(InputView.INPUT_PLAYER_ONE_MESSAGE);
        List<Integer> playerTwoPosition = createPlayerPosition(InputView.INPUT_PLAYER_TWO_MESSAGE);

        GameResult playerOneResult = new GameResult(computerPosition, playerOnePosition);
        GameResult playerTwoResult = new GameResult(computerPosition, playerTwoPosition);

        OutputView outputView = new OutputView(playerOneResult, playerTwoResult);

        outputView.printClearMessage();
        outputView.printGameResult();
    }

    private List<Integer> createPlayerPosition(String inputMessage) {
        try {
            System.out.print(inputMessage);
            String input = InputView.inputPlayerPosition();
            return new PlayerPosition(input).getPlayerPosition();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createPlayerPosition(inputMessage);
        }
    }
}
