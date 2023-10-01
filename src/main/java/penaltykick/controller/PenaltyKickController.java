package penaltykick.controller;

import java.util.List;

import penaltykick.domain.Player;
import penaltykick.view.InputView;

public class PenaltyKickController {

	private final InputView inputView;

	public PenaltyKickController(InputView inputView) {
		this.inputView = inputView;
	}

	private Player inputPlayer() {
		List<Integer> playerNumber = inputView.readPlayerNumber();
		return new Player(playerNumber);
	}
}
