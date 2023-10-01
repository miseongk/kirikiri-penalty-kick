package penaltykick.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

	private final Scanner scanner = new Scanner(System.in);

	public List<Integer> readPlayerNumber() {
		String readNumber = scanner.next();
		validateBlank(readNumber);
		return splitWord(readNumber);
	}

	private void validateBlank(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("반칸이 입력될 수 없습니다.");
		}
	}

	private int validateInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 값은 입력될 수 없습니다.");
		}
	}

	private List<Integer> splitWord(String input) {
		return Arrays.stream(input.split(" "))
			.map(this::validateInteger)
			.collect(Collectors.toList());
	}
}
