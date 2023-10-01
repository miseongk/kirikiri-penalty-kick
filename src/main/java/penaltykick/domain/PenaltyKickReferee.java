package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;

public class PenaltyKickReferee {

	private static final int REPEAT_NUMBER = 5;

	private final NumberGenerator numberGenerator;

	public PenaltyKickReferee(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public void calculate

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
