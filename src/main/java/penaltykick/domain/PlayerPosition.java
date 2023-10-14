package penaltykick.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import penaltykick.constant.Constant;
import penaltykick.constant.errorMessage.PlayerPositionError;

public class PlayerPosition {
	private final List<Integer> playerPosition;

	public PlayerPosition(String input) {
		List<Integer> playerPositionList = createPlayerPosition(input);
		validatePlayerInputSize(playerPositionList);
		validatePlayerInputRange(playerPositionList);
		this.playerPosition = playerPositionList;
	}

	private List<Integer> createPlayerPosition(String input) {
		return Arrays.stream(input.split(" "))
			.map(PlayerPosition::validatePlayerInputNumber)
			.collect(Collectors.toList());
	}

	private static int validatePlayerInputNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(PlayerPositionError.PLAYER_POSITION_WRONG_INPUT_ERROR_MESSAGE);
		}
	}

	private void validatePlayerInputSize(List<Integer> playerPos) {
		if (playerPos.size() != Constant.POSITION_LENGTH) {
			throw new IllegalArgumentException(PlayerPositionError.PLAYER_POSITION_WRONG_SIZE_ERROR_MESSAGE);
		}
	}

	private void validatePlayerInputRange(List<Integer> playerPos) {
		if (playerPos.stream().anyMatch(pos -> Constant.START_RANGE > pos || pos > Constant.END_RANGE)) {
			throw new IllegalArgumentException(PlayerPositionError.PLAYER_POSITION_WRONG_RANGE_ERROR_MESSAGE);
		}
	}

	public List<Integer> getPlayerPosition() {
		return playerPosition;
	}
}
