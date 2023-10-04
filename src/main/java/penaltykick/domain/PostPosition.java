package penaltykick.domain;

import java.util.Arrays;

public enum PostPosition {
    LEFT(1),
    MIDDLE(2),
    RIGHT(3);

    private final int position;

    PostPosition(int position) {
        this.position = position;
    }

    public static PostPosition valueOf(int position) {
        return Arrays.stream(values())
                .filter(v -> v.position == position)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d는 골대의 위치가 될 수 없습니다.", position)));
    }
}
