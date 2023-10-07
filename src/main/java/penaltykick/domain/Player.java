package penaltykick.domain;

import java.util.List;

public class Player {

	private static final int MIN_PLAYER_NUMBER = 1;
	private static final int MAX_PLAYER_NUMBER = 3;

	private final List<Integer> playerNumber;

	public Player(List<Integer> playerNumber) {
		validatePlayerInputSize(playerNumber);
		validatePlayerNumberRange(playerNumber);
		this.playerNumber = playerNumber;
	}

	private void validatePlayerNumberRange(List<Integer> playerNumber) {
		if (playerNumber.stream().anyMatch(number -> number < MIN_PLAYER_NUMBER || number > MAX_PLAYER_NUMBER)) {
			throw new IllegalArgumentException("입력할 수 있는 숫자의 범위를 벗어났습니다.");
		}
	}

	private void validatePlayerInputSize(List<Integer> playerNumber) {
		if (playerNumber.size() != 5) {
			throw new IllegalArgumentException("입력할 수 있는 개수의 범위를 벗어났습니다.");
		}
	}

	public int getPlayerNumberByIndex(int index) {
		return playerNumber.get(index);
	}
}
