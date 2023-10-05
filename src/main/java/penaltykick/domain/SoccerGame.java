package penaltykick.domain;

import java.util.List;

public class SoccerGame {
	private final List<Integer> computerPosition;
	private List<Integer> playerPosition;
	private GameResult gameResult;

	public SoccerGame(List<Integer> computerPos) {
		this.computerPosition = computerPos;
	}

	public void inputPlayerPosision(String str) {
		this.playerPosition = new PlayerPosition(str).getPlayerPosition();
	}

	public void playerCountScore() {
		this.gameResult = new GameResult(computerPosition, playerPosition);
	}

	public GameResult getGameResult() {
		return gameResult;
	}
}
