package penaltykick.domain.position;

import java.util.List;

public final class KeeperPositions {
    private final PenaltyPositions keeperPositions;

    public KeeperPositions(PenaltyPositions penaltyPositions) {
        this.keeperPositions = penaltyPositions;
    }

    public List<Boolean> matchPositions(BallPositions ballPositions) {
        return keeperPositions.matchPositions(ballPositions.unwrap());
    }
}
