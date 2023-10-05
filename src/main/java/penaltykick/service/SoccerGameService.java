package penaltykick.service;

import penaltykick.domain.GameResult;
import penaltykick.domain.SoccerGame;

public class SoccerGameService {
	private SoccerGame soccerGame;

	public void initSoccerGame() {
		this.soccerGame = new SoccerGame();
	}

	public GameResult compareTwoPosition(String playerInput) {
		soccerGame.inputPlayerPosision(playerInput);
		soccerGame.playerCountScore();
		return soccerGame.getGameResult();
	}
}
