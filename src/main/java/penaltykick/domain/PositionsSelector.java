package penaltykick.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PositionsSelector {
    private static final Random RANDOM = new Random();
    private static final PostPosition[] POSITIONS = PostPosition.values();
    private PositionsSelector() {}

    public static List<PostPosition> selectPositions(int count) {
        return IntStream.range(0, count)
                .map(i -> RANDOM.nextInt(POSITIONS.length))
                .mapToObj(pick -> POSITIONS[pick])
                .collect(Collectors.toList());
    }
}
