package penaltykick.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PlayerPositionTest {

    @Test
    void 입력_받는지_테스트() {
        String input = "1 3 2 2 1";
        int[] pos = {1, 3, 2, 2, 1};
        int[] playerPos = new PlayerPosition(input).getPlayerPosition().stream().mapToInt(num -> num).toArray();
        assertArrayEquals(pos, playerPos);
    }

    @Test
    void 입력_길이_초과_테스트() {
        String input = "1 3 2 2 1 2";
        assertThrows(IllegalArgumentException.class, () -> {
            new PlayerPosition(input);
        });
    }

    @Test
    void 입력_예외_테스트1() {
        String input = "1 3 ~ 2 1";
        assertThrows(IllegalArgumentException.class, () -> {
            new PlayerPosition(input);
        });
    }

    @Test
    void 입력_예외_테스트2() {
        String input = "1 3 4 2 1";
        assertThrows(IllegalArgumentException.class, () -> {
            new PlayerPosition(input);
        });
    }
}
