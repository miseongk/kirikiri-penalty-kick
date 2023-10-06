package penaltykick.domain.position;

import java.util.List;

public final class KeeperPositions {
    private final PenaltyPositions keeperPositions;

    public KeeperPositions(List<PostPosition> keeperPositions) {
        this.keeperPositions = new PenaltyPositions(keeperPositions);
    }
}
