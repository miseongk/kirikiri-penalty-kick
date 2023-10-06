package penaltykick.domain;

import java.util.List;
import java.util.stream.Collectors;
import penaltykick.domain.position.BallPositions;
import penaltykick.domain.position.KeeperPositions;

public class Round {
    private final KeeperPositions keeperPositions;
    private final BallPositions ballPositions;

    public Round(KeeperPositions keeperPositions, BallPositions ballPositions) {
        this.keeperPositions = keeperPositions;
        this.ballPositions = ballPositions;
    }

    public List<GoalResult> getGoalResult() {
        return matchPositions().stream()
                .map(GoalResult::fromPositionMatched)
                .collect(Collectors.toList());
    }

    private List<Boolean> matchPositions() {
        return keeperPositions.matchPositions(ballPositions);
    }
}
