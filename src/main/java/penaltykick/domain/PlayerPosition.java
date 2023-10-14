package penaltykick.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import penaltykick.constant.Constant;

public class PlayerPosition {
	private final List<Integer> playerPosition;

	public PlayerPosition(String playerInput) {
		this.playerPosition = createPlayerPosition(playerInput);
	}

	private List<Integer> createPlayerPosition(String str) throws IllegalArgumentException {
		int[] playerPosition = convertStringToInt(str);
		if (!checkValidPosition(playerPosition)) {
			throw new IllegalArgumentException();
		}
		return Arrays.stream(playerPosition).boxed().collect(Collectors.toList());
	}

	private int[] convertStringToInt(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private boolean checkValidPosition(int[] playerPos) {
		return isRightLength(playerPos) && isNumber(playerPos);
	}

	private boolean isRightLength(int[] playerPos) {
		return playerPos.length == Constant.POSITION_LENGTH;
	}

	private boolean isNumber(int[] playerPos) {
		return Arrays.stream(playerPos).allMatch(pos -> Constant.START_RANGE <= pos && pos <= Constant.END_RANGE);
	}

	public List<Integer> getPlayerPosition() {
		return playerPosition;
	}
}
