package penaltykick.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import penaltykick.domain.position.PenaltyPositions;
import penaltykick.domain.position.PostPosition;

public class PositionsSelector {
    private static final Random RANDOM = new Random();
    private static final PostPosition[] POSITIONS = PostPosition.values();

    private PositionsSelector() {}

    public static PenaltyPositions selectPositions(int count) {
        return new PenaltyPositions(selectRandomPositions(count));
    }

    private static List<PostPosition> selectRandomPositions(int count) {
        return IntStream.range(0, count)
                .map(i -> RANDOM.nextInt(POSITIONS.length))
                .mapToObj(pick -> POSITIONS[pick])
                .collect(Collectors.toList());
    }
}
