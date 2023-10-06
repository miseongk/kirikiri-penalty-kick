package penaltykick.domain.position;

import java.util.List;
import java.util.stream.Collectors;
import penaltykick.domain.GoalResult;

public final class KeeperPositions {
    private final PenaltyPositions keeperPositions;

    public KeeperPositions(PenaltyPositions penaltyPositions) {
        this.keeperPositions = penaltyPositions;
    }

    public KeeperPositions(List<Integer> selectedPositions) {
        List<PostPosition> keeperPositions = selectedPositions.stream()
                .map(PostPosition::valueOf)
                .collect(Collectors.toList());

        this.keeperPositions = new PenaltyPositions(keeperPositions);
    }

    public List<Boolean> matchPositions(BallPositions ballPositions) {
        return keeperPositions.matchPositions(ballPositions.unwrap());
    }
}
