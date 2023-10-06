package penaltykick.domain.position;

import java.util.List;
import java.util.stream.Collectors;
import penaltykick.domain.GoalResult;

public final class KeeperPositions {
    private final PenaltyPositions keeperPositions;

    public KeeperPositions(List<PostPosition> keeperPositions) {
        this.keeperPositions = new PenaltyPositions(keeperPositions);
    }

    public List<Boolean> matchPositions(BallPositions ballPositions) {
        return keeperPositions.matchPositions(ballPositions.unwrap());
    }
}
