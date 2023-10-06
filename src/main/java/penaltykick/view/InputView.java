package penaltykick.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = " ";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static List<Integer> readBallPositions(int count, String name) {
        System.out.printf("총 %d번의 위치를 입력해주세요.\n", count);
        System.out.printf("%s : ", name);
        String ballPositions = scanner.nextLine();

        validateIsSeparatedNumber(ballPositions);

        return Arrays.stream(ballPositions.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private static void validateIsSeparatedNumber(String input) {
        if (!isSeparatedNumber(input)) {
            throw new IllegalArgumentException(String.format("[ERROR] 공의 위치는 %s로 구분되는 숫자여야 합니다.", DELIMITER));
        }
    }

    private static boolean isSeparatedNumber(String input) {
        return !input.endsWith(DELIMITER) && Arrays.stream(input.split(DELIMITER)).allMatch(InputView::isNumber);
    }

    private static boolean isNumber(String string) {
        return !string.isEmpty() && string.chars().allMatch(Character::isDigit);
    }
}
