package penaltykick.domain;

import java.util.List;

public class Computer {

	private static final int MAX_COMPUTER_NUMBER = 3;

	private final List<Integer> computerNumbers;

	public Computer(List<Integer> computerNumbers) {
		validateComputerNumber(computerNumbers);
		this.computerNumbers = computerNumbers;
	}

	private void validateComputerNumber(List<Integer> computerNumbers) {
		if (computerNumbers.stream().anyMatch(number -> number > MAX_COMPUTER_NUMBER)) {
			throw new IllegalArgumentException("컴퓨터 숫자 생성에 오류가 발생하였습니다.");
		}
	}

	public boolean checkNumberByPlayer(int playerNumber, int i) {
		return computerNumbers.get(i) == playerNumber;
	}

	public int getComputerNumberSize() {
		return computerNumbers.size();
	}
}
