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

        List<Integer> firstBallPositions = InputView.readBallPositions(FIRST_PLAYER_NAME);
        List<Integer> secondBallPositions = InputView.readBallPositions(SECOND_PLAYER_NAME);

        determineGameResult(firstBallPositions, secondBallPositions);
    }

    private static void determineGameResult(List<Integer> firstBallPositions, List<Integer> secondBallPositions) {
        RoundResult firstRoundResult = GameService.playRound(firstBallPositions, FIRST_PLAYER_NAME);
        RoundResult secondRoundResult = GameService.playRound(secondBallPositions, SECOND_PLAYER_NAME);

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
