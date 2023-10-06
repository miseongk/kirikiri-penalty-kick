package penaltykick.domain;

import java.util.List;
import penaltykick.domain.position.PenaltyPositions;
import penaltykick.domain.position.PostPosition;

public final class KeeperPositions {
    private final PenaltyPositions keeperPositions;

    public KeeperPositions(List<PostPosition> keeperPositions) {
        this.keeperPositions = new PenaltyPositions(keeperPositions);
    }
}
