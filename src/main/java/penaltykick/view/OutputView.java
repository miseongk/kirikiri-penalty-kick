package penaltykick.view;

import java.util.List;

public class OutputView {

	private static final String LINE_BREAK = System.lineSeparator();
	private static final String SAME = "O";
	private static final String NOT_SAME = "X";

	private OutputView() {
	}

	public static void printStartMessage() {
		System.out.println("패널티 킥 게임을 시작합니다.");
	}

	public static void printInputMessage() {
		System.out.println("총 5번의 위치를 입력해주세요.");
	}

	public static void printFirstPlayerInputMessage() {
		System.out.print("플레이어 1: ");
	}

	public static void printSecondPlayerInputMessage() {
		System.out.print("플레이어 2: ");
	}

	public static void printGameResult() {
		System.out.print(LINE_BREAK);
		System.out.println("게임 결과");
	}

	public static void printCalculateResult(List<Boolean> results) {
		StringBuilder stringBuilder = new StringBuilder();
		for (boolean result : results) {
			checkSame(stringBuilder, result);
		}
		System.out.println("플레이어1 : " + stringBuilder);
	}

	private static void checkSame(StringBuilder stringBuilder, boolean result) {
		if (result) {
			stringBuilder.append(SAME);
			return;
		}
		stringBuilder.append(NOT_SAME);
	}

	public static void printWinner(long firstPlayerResult, long secondPlayerResult) {
		if (firstPlayerResult > secondPlayerResult) {
			System.out.println("플레이어1이(가) 우승했습니다\uD83C\uDF89");
		}
		if (firstPlayerResult < secondPlayerResult) {
			System.out.println("플레이어2이(가) 우승했습니다\uD83C\uDF89");
		}
		if (firstPlayerResult == secondPlayerResult) {
			System.out.println("무승부입니다.");
		}
	}
}
