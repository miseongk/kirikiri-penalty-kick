package penaltykick.view;

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
}
