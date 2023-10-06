package penaltykick.domain.position;

import java.util.List;
import java.util.stream.Collectors;

public final class BallPositions {
    private final PenaltyPositions ballPositions;

    public BallPositions(List<Integer> selectedPositions) {
        List<PostPosition> ballPositions = selectedPositions.stream()
                .map(PostPosition::fromPosition)
                .collect(Collectors.toList());

        this.ballPositions = new PenaltyPositions(ballPositions);
    }

    PenaltyPositions unwrap() {
        return ballPositions;
    }
}
