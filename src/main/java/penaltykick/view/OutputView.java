package penaltykick.view;

public class OutputView {
	public static void printGameStart() {
		System.out.println("패널티 킥 게임을 시작합니다.\n" +
				"    총 5번의 위치를 입력해주세요.");

	}

	public static void printFinalResult(Player winner) {
		if (winner == null) {
			System.out.println("무승부입니다.");
			return;
		}
		System.out.printf("%s이(가) 우승했습니다\uD83C\uDF89", winner.getName());
	}
}
