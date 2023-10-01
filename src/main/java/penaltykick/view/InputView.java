package penaltykick.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static int readPlayerNumber() {
		String readNumber = scanner.next();
		validateBlank(readNumber);
		return validateInteger(readNumber);
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
}
