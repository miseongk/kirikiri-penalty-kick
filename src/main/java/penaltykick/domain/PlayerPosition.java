package penaltykick.domain;

import java.util.List;

public class PlayerPosition {
	private static final int POSITION_LENGTH = 5;
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 3;
	private final List<Integer> playerPosition;

	public PlayerPosition(List<Integer> playerPosition) {
		this.playerPosition = playerPosition;
	}
}
