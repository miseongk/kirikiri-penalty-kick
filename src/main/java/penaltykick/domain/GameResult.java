package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameResult {
	public final int goalCount;
	public final List<Boolean> convertResult;

	public GameResult(List<Integer> computerPos, List<Integer> playerPos) {
		this.convertResult = convertGameResult(computerPos, playerPos);
		this.goalCount = countGoal();
	}

	private int countGoal() {
		return (int)Stream.iterate(0, i -> i + 1)
			.limit(convertResult.size())
			.filter(pos -> convertResult.get(pos).equals(true))
			.count();
	}

	private List<Boolean> convertGameResult(List<Integer> computerPos, List<Integer> playerPos) {
		List<Boolean> convertList = new ArrayList<>();
		for (int i = 0; i < computerPos.size(); i++) {
			convertList.add(convertProcess(computerPos.get(i), playerPos.get(i)));
		}
		return convertList;
	}

	private boolean convertProcess(int computerPosVal, int playerPosVal) {
		return computerPosVal == playerPosVal;
	}
}
