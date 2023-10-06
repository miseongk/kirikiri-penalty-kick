package penaltykick.service;

import java.util.List;
import penaltykick.domain.GoalResult;

public class GameService {
    private GameService() {}

    public static int CountGoal(List<GoalResult> goalResults) {
        long goalCount = goalResults.stream()
                .filter(GoalResult.GOAL::equals)
                .count();

        return Math.toIntExact(goalCount);
    }
}
