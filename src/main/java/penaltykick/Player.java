package penaltykick;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	// 플레이어 숫자 입력 받는 메소드
	public static Scanner scanner = new Scanner(System.in);
	public ArrayList<Integer> playerNumberGenerator(int count) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			try {
				int num = scanner.nextInt();
				if (num < 1 || num > 3){
					throw new IllegalArgumentException("유효하지 않은 값입니다. 1, 2, 3 중 하나를 입력하세요.");
				}
				numbers.add(num);
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				System.exit(1);
			}
		}
		return numbers;
	}
}
