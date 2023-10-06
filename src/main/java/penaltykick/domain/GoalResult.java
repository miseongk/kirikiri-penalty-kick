package penaltykick.domain;

public enum GoalResult {
    GOAL,
    NO_GOAL;

    public static GoalResult fromPositionMatched(boolean isPositionMatched) {
        if (isPositionMatched) {
            return NO_GOAL;
        }

        return GOAL;
    }
}
