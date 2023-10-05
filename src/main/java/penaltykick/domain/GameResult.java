package penaltykick.domain;

import java.util.Arrays;
import java.util.List;

public class GameResult {
	private static final String GOAL_SUCCESS = "O";
	private static final String GOAL_FAIL = "X";
	public final int goalCount;
	public final String convertResult;

	public GameResult(List<Integer> computerPos, List<Integer> playerPos) {
		this.convertResult = convertGameResult(computerPos, playerPos);
		this.goalCount = countGoal(computerPos, playerPos);
	}

	private int countGoal(List<Integer> computerPos, List<Integer> playerPos) {
		return (int)Arrays.stream(convertResult.split(""))
			.filter(pos -> pos.contains(GOAL_SUCCESS)).count();
	}

	private String convertGameResult(List<Integer> computerPos, List<Integer> playerPos) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < computerPos.size(); i++) {
			sb.append(convertProcess(computerPos.get(i), playerPos.get(i)));
		}
		return sb.toString();
	}

	private String convertProcess(int computerPosIndi, int playerPosIndi) {
		if (computerPosIndi == playerPosIndi) {
			return GOAL_SUCCESS;
		}
		return GOAL_FAIL;
	}
}
