package penaltykick.service;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;
import penaltykick.domain.GameResult;
import penaltykick.domain.GoalResult;

public class GameService {
    private GameService() {}

    public static int countGoal(GameResult goalResult) {
        long goalCount = goalResult.getGoalResults().stream()
                .filter(GoalResult.GOAL::equals)
                .count();

        return Math.toIntExact(goalCount);
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
