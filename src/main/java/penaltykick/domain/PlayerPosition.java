package penaltykick.domain;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
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
		return Arrays.stream(playerPosition).boxed().collect(Collectors.toList());
	}

	private int[] convertStringToInt(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	public List<Integer> getPlayerPosition() {
		return playerPosition;
	}
}
