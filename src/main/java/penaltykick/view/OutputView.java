package penaltykick.view;

import penaltykick.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	public static void printGameStart() {
		System.out.println("패널티 킥 게임을 시작합니다.\n" +
				"총 5번의 위치를 입력해주세요.");

	}

	public static void printWinner(Player winner) {
		if (winner == null) {
			System.out.println("무승부입니다.");
			return;
		}
		System.out.printf("%s이(가) 우승했습니다\uD83C\uDF89\n", winner.getName());
	}

	public static void printKickResult(Player player, List<Boolean> kickResult) {
		String result = kickResult.stream()
				.map(isSamePosition -> {
					if (isSamePosition) return "X";
					return "O";
				}).collect(Collectors.joining(""));
		System.out.printf("%s : %s\n", player.getName(), result);
	}
}
