package penaltykick.view;

import java.util.List;
import java.util.Map;
import penaltykick.domain.GoalResult;

public class OutputView {
    private static final String GOAL_SIGN = "O";
    private static final String NO_GOAL_SIGN = "X";
    private static final Map<GoalResult, String> RESULT_SIGN_MAP = Map.of(
            GoalResult.GOAL, GOAL_SIGN,
            GoalResult.NO_GOAL, NO_GOAL_SIGN
    );

    private OutputView() {}

    public static void printGoalResults(List<GoalResult> goalResults, String name) {
        System.out.printf("%s : ", name);

        goalResults.stream()
                .map(RESULT_SIGN_MAP::get)
                .forEach(System.out::print);

        System.out.println();
    }
}
