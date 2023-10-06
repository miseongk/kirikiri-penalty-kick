package penaltykick.controller;

import java.util.List;
import java.util.Optional;
import penaltykick.domain.GameResult;
import penaltykick.domain.position.PenaltyPositions;
import penaltykick.service.GameService;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class GameController {
    private static final String FIRST_PLAYER_NAME = "플레이어1";
    private static final String SECOND_PLAYER_NAME = "플레이어2";

    private GameController() {}

    public static void playGame() {
        int attemptsCount = PenaltyPositions.getAttemptsCount();

        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.printf("총 %d번의 위치를 입력해주세요.\n", attemptsCount);

        List<Integer> firstBallPositions = InputView.readBallPositions(FIRST_PLAYER_NAME);
        List<Integer> secondBallPositions = InputView.readBallPositions(SECOND_PLAYER_NAME);

        determineGameResult(firstBallPositions, secondBallPositions);
    }

    private static void determineGameResult(List<Integer> firstBallPositions, List<Integer> secondBallPositions) {
        GameResult firstGameResult = GameService.startRound(firstBallPositions, FIRST_PLAYER_NAME);
        GameResult secondGameResult = GameService.startRound(secondBallPositions, SECOND_PLAYER_NAME);

        printGameResults(firstGameResult, secondGameResult);
        printWinner(firstGameResult, secondGameResult);
    }

    private static void printGameResults(GameResult firstGameResult, GameResult secondGameResult) {
        OutputView.printGameResults(firstGameResult);
        OutputView.printGameResults(secondGameResult);
    }

    private static void printWinner(GameResult firstGameResult, GameResult secondGameResult) {
        Optional<String> winner = GameService.getWinner(firstGameResult, secondGameResult);

        if (winner.isEmpty()) {
            OutputView.printDraw();
            return;
        }

        OutputView.printWinner(winner.get());
    }
}
