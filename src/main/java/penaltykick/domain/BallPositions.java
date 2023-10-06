package penaltykick.domain;

import java.util.List;
import penaltykick.domain.position.PenaltyPositions;
import penaltykick.domain.position.PostPosition;

public final class BallPositions {
    private final PenaltyPositions ballPositions;

    public BallPositions(List<PostPosition> ballPositions) {
        this.ballPositions = new PenaltyPositions(ballPositions);
    }
}
