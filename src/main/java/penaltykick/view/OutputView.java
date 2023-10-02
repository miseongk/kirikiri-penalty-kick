package penaltykick.view;

import java.util.List;

public class OutputView {

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
		System.out.println("게임 결과");
	}

	public static void printFirstPlayerResult(List<String> result) {
		System.out.println("플레이어1 : " + result);
	}

	public static void printSecondPlayerResult(List<String> result) {
		System.out.println("플레이어2 : " + result);
	}

	public static void printWinner(int firstPlayerResult, int secondPlayerResult) {
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
