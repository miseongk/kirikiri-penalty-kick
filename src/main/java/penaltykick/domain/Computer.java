package penaltykick.domain;

import java.util.List;

public class Computer {

	private final List<Integer> computerNumbers;

	public Computer(List<Integer> computerNumbers) {
		this.computerNumbers = computerNumbers;
	}

	public boolean checkNumberByPlayer(int playerNumber) {
		return computerNumbers.contains(playerNumber);
	}
}
