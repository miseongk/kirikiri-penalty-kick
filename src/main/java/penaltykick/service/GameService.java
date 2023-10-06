package penaltykick.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import penaltykick.domain.GameResult;
import penaltykick.domain.GoalResult;
import penaltykick.domain.PositionsSelector;
import penaltykick.domain.Round;
import penaltykick.domain.position.BallPositions;
import penaltykick.domain.position.KeeperPositions;
import penaltykick.domain.position.PenaltyPositions;

public class GameService {
    private static KeeperPositions keeperPositions;

    static {
        int attemptsCount = PenaltyPositions.getAttemptsCount();
        keeperPositions = new KeeperPositions(PositionsSelector.selectPositions(attemptsCount));
    }

    private GameService() {}

    public static int countGoal(GameResult goalResult) {
        long goalCount = goalResult.getGoalResults().stream()
                .filter(GoalResult.GOAL::equals)
                .count();

        return Math.toIntExact(goalCount);
    }

    public static GameResult startRound(List<Integer> BallPosition, String playerName) {
        Round round = new Round(keeperPositions, new BallPositions(BallPosition));

        return new GameResult(round.getGoalResult(), playerName);
    }

    public static Optional<String> getWinner(GameResult gameResult1, GameResult gameResult2) {
        if (countGoal(gameResult1) == countGoal(gameResult2)) {
            return Optional.empty();
        }

        return Stream.of(gameResult1, gameResult2)
                .max(Comparator.comparingInt(GameService::countGoal))
                .map(GameResult::getPlayerName);
    }
}
