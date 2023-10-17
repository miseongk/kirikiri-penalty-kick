package penaltykick.controller;

import java.util.List;
import java.util.Optional;
import penaltykick.domain.RoundResult;
import penaltykick.domain.position.PenaltyPositions;
import penaltykick.service.GameService;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class GameController {
    private static final String FIRST_PLAYER_NAME = "플레이어1";
    private static final String SECOND_PLAYER_NAME = "플레이어2";

    private GameController() {}

    public static void playGame() {
        OutputView.printGameStartMessage(PenaltyPositions.getAttemptsCount());

        RoundResult firstRoundResult = playRound(FIRST_PLAYER_NAME);
        RoundResult secondRoundResult = playRound(SECOND_PLAYER_NAME);

        determineGameResult(firstRoundResult, secondRoundResult);
    }

    private static RoundResult playRound(String name) {
        while (true) {
            try {
                List<Integer> BallPositions = InputView.readBallPositions(name);
                return GameService.playRound(BallPositions, name);
            } catch (IllegalArgumentException exception) {
                OutputView.printExceptionMessage(exception);
            }
        }
    }

    private static void determineGameResult(RoundResult firstRoundResult, RoundResult secondRoundResult) {
         printGameResults(firstRoundResult, secondRoundResult);
        printWinner(firstRoundResult, secondRoundResult);
    }

    private static void printGameResults(RoundResult firstRoundResult, RoundResult secondRoundResult) {
        OutputView.printGameResultMessage();
        OutputView.printRoundResult(firstRoundResult);
        OutputView.printRoundResult(secondRoundResult);
    }

    private static void printWinner(RoundResult firstRoundResult, RoundResult secondRoundResult) {
        Optional<String> winner = GameService.getWinner(firstRoundResult, secondRoundResult);

        if (winner.isEmpty()) {
            OutputView.printDraw();
            return;
        }

        OutputView.printWinner(winner.get());
    }
}
