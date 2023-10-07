package penaltykick.domain;

import java.util.Arrays;

public class PenaltyKickReferee {

	private static final String ALPHABET_O = "O";
	private static final String ALPHABET_X = "X";

	public String calculateResult(Computer computer, Player player) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < computer.getComputerNumberSize(); i++) {
			if (computer.checkNumberByPlayer(player.getPlayerNumberByIndex(i), i)) {
				stringBuilder.append(ALPHABET_O);
			}
			if (!computer.checkNumberByPlayer(player.getPlayerNumberByIndex(i), i)) {
				stringBuilder.append(ALPHABET_X);
			}
		}
		return stringBuilder.toString();
	}

	public long resultCount(String result) {
		return Arrays.stream(result.split(""))
			.filter(element -> element.contains(ALPHABET_O))
			.count();
	}
}
