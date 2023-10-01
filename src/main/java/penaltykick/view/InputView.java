package penaltykick.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static List<Integer> readPlayerNumber() {
		String readNumber = scanner.nextLine();
		validateBlank(readNumber);
		return splitWord(readNumber);
	}

	private static void validateBlank(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("반칸이 입력될 수 없습니다.");
		}
	}

	private static int validateInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 값은 입력될 수 없습니다.");
		}
	}

	private static List<Integer> splitWord(String input) {
		return Arrays.stream(input.split(" "))
			.map(InputView::validateInteger)
			.collect(Collectors.toList());
	}
}
