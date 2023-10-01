package penaltykick.controller;

import java.util.List;

import penaltykick.domain.Computer;
import penaltykick.domain.PenaltyKickReferee;
import penaltykick.domain.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class PenaltyKickController {

	private final PenaltyKickReferee penaltyKickReferee;

	public PenaltyKickController(PenaltyKickReferee penaltyKickReferee) {
		this.penaltyKickReferee = penaltyKickReferee;
	}

	public void run() {
		OutputView.printStartMessage();
		startGame();
	}

	private void startGame() {
		Computer computerNumbers = createComputerNumber();
		OutputView.printFirstPlayerInputMessage();
		Player firstPlayer = createPlayer();
		OutputView.printSecondPlayerInputMessage();
		Player secondPlayer = createPlayer();
	}

	private Player createPlayer() {
		List<Integer> playerNumbers = InputView.readPlayerNumber();
		return penaltyKickReferee.generatePlayer(playerNumbers);
	}

	private Computer createComputerNumber() {
		OutputView.printInputMessage();
		return penaltyKickReferee.generateComputer();
	}
}
