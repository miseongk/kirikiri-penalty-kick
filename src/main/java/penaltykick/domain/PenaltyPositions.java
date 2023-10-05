package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PenaltyPositions {
    private static final int ATTEMPTS_COUNT = 5;

    private final List<PostPosition> selectedPositions;

    public PenaltyPositions(List<PostPosition> selectedPositions) {
        this.selectedPositions = new ArrayList<>(selectedPositions);
        validateSize();
    }

    private void validateSize() {
        if (selectedPositions.size() != ATTEMPTS_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 패널티킥은 총 %d번의 시도여야 합니다.", ATTEMPTS_COUNT));
        }
    }

    public List<Boolean> matchPositions(PenaltyPositions penaltyPositions) {
        return IntStream.range(0, ATTEMPTS_COUNT)
                .mapToObj(turn -> this.get(turn) == penaltyPositions.get(turn))
                .collect(Collectors.toList());
    }

    private PostPosition get(int index) {
        return selectedPositions.get(index);
    }
}
