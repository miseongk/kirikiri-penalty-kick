package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;

public final class PenaltyKickAttempts {
    private static final int ATTEMPTS_COUNT = 5;

    private final List<PositionInPost> selectedPositions;

    public PenaltyKickAttempts(List<PositionInPost> selectedPositions) {
        this.selectedPositions = new ArrayList<>(selectedPositions);
        validateSize();
    }

    private void validateSize() {
        if (selectedPositions.size() != ATTEMPTS_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 패널티킥은 총 %d번의 시도여야 합니다.", ATTEMPTS_COUNT));
        }
    }
}

