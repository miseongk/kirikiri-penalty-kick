package penaltykick;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	// 플레이어 숫자 입력 받는 메소드
	public static Scanner scanner = new Scanner(System.in);
	public ArrayList<Integer> playerNumberGenerator(int count) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			int num = readValidInput();
			numbers.add(num);
		}
		return numbers;
	}

	private int readValidInput() {
		int num = 0;
		boolean validInput = false;

		while (!validInput) {
			try {
				num = readInput();
				validateInput(num);
				validInput = true;
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				scanner.nextLine();
			}
		}
		return num;
	}

	private int readInput() {
		return scanner.nextInt();
	}

	private void validateInput(int num) {
		if (num < 1 || num > 3) {
			throw new IllegalArgumentException("유효하지 않은 값입니다. 1, 2, 3 중 하나를 입력하세요.");
		}
	}
}

