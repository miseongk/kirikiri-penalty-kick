package penaltykick.service;

import java.util.List;

import penaltykick.domain.GameResult;
import penaltykick.domain.SoccerGame;

public class SoccerGameService {
	private SoccerGame soccerGame;

	public void initSoccerGame(List<Integer> computerPos) {
		this.soccerGame = new SoccerGame(computerPos);
	}

	public GameResult compareTwoPosition(String playerInput) {
		soccerGame.inputPlayerPosision(playerInput);
		soccerGame.playerCountScore();
		return soccerGame.getGameResult();
	}
}
