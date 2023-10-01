package penaltykick.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static String readPlayerNumber() {
		String readNumber = scanner.next();
		validateBlank(readNumber);
		return readNumber;
	}

	private static void validateBlank(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("반칸이 입력될 수 없습니다.");
		}
	}
}
