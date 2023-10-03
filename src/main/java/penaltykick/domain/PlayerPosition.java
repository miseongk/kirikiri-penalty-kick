package penaltykick.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerPosition {
	private static final int POSITION_LENGTH = 5;
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 3;
	private final List<Integer> playerPosition;

	public PlayerPosition(String playerInput) {
		this.playerPosition = createPlayerPosition(playerInput);
	}

	private List<Integer> createPlayerPosition(String str) throws IllegalArgumentException {
		int[] playerPosition = convertStringToInt(str);
		if (checkValidPosition(playerPosition)) {

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
		return playerPos.length == POSITION_LENGTH;
	}
	private boolean isNumber(int[] playerPos) {
		return Arrays.stream(playerPos).allMatch(pos -> START_RANGE <= pos && pos <= END_RANGE);
	}

	public List<Integer> getPlayerPosition() {
		return playerPosition;
	}
}
