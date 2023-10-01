package penaltykick.controller;

import java.util.List;

import penaltykick.domain.Player;
import penaltykick.view.InputView;

public class PenaltyKickController {

	private final InputView inputView;

	public PenaltyKickController(InputView inputView) {
		this.inputView = inputView;
	}

	public void run() {
		startGame();

	}

	private void startGame() {
		Player firstPlayer = inputPlayer();
		Player secondPlayer = inputPlayer();
	}

	private Player inputPlayer() {
		List<Integer> playerNumber = inputView.readPlayerNumber();
		return new Player(playerNumber);
	}
}
