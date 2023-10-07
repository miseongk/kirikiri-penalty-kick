package penaltykick.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import penaltykick.domain.RoundResult;
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

    public static int countGoals(RoundResult roundResult) {
        long goalCount = roundResult.getGoalResults().stream()
                .filter(GoalResult.GOAL::equals)
                .count();

        return Math.toIntExact(goalCount);
    }

    public static RoundResult playRound(List<Integer> BallPosition, String playerName) {
        Round round = new Round(keeperPositions, new BallPositions(BallPosition));

        return new RoundResult(round.getGoalResults(), playerName);
    }

    public static Optional<String> getWinner(RoundResult firstRoundResult, RoundResult secondRoundResult) {
        if (countGoals(firstRoundResult) == countGoals(secondRoundResult)) {
            return Optional.empty();
        }

        return Stream.of(firstRoundResult, secondRoundResult)
                .max(Comparator.comparingInt(GameService::countGoals))
                .map(RoundResult::getPlayerName);
    }
}
