package penaltykick.domain.position;

import java.util.List;

public final class BallPositions {
    private final PenaltyPositions ballPositions;

    public BallPositions(List<PostPosition> ballPositions) {
        this.ballPositions = new PenaltyPositions(ballPositions);
    }
}
