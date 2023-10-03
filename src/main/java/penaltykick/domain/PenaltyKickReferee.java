package penaltykick.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PenaltyKickReferee {

	private static final int REPEAT_NUMBER = 5;
	private static final String ALPHABET_O = "O";
	private static final String ALPHABET_X = "X";

	private final NumberGenerator numberGenerator;

	public PenaltyKickReferee(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

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

	public Computer generateComputer() {
		List<Integer> computerNumber = generateRandomNumber();
		return new Computer(computerNumber);
	}

	public List<Integer> generateRandomNumber() {
		List<Integer> computerNumber = new ArrayList<>();
		for (int i = 0; i < REPEAT_NUMBER; i++) {
			computerNumber.add(numberGenerator.generate());
		}
		return computerNumber;
	}

	public Player generatePlayer(List<Integer> playerNumbers) {
		return new Player(playerNumbers);
	}
}
