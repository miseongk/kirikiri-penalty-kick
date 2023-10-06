package penaltykick.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = " ";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> readBallPositions(int count, String name) {
        System.out.printf("총 %d번의 위치를 입력해주세요.\n", count);
        System.out.printf("%s : ", name);
        String ballPositions = scanner.nextLine();

        return Arrays.stream(ballPositions.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
}
