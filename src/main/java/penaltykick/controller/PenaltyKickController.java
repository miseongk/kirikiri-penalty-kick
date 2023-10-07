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

		String firstPlayerResult = calculate(computerNumbers, firstPlayer);
		String secondPlayerResult = calculate(computerNumbers, secondPlayer);

		printGameResult(firstPlayerResult, secondPlayerResult);

		createWinner(firstPlayerResult, secondPlayerResult);
	}

	private Computer createComputerNumber() {
		OutputView.printInputMessage();
		return penaltyKickReferee.generateComputer();
	}

	private Player createPlayer() {
		List<Integer> playerNumbers = InputView.readPlayerNumber();
		return penaltyKickReferee.generatePlayer(playerNumbers);
	}

	private static void printGameResult(String firstPlayerResult, String secondPlayerResult) {
		OutputView.printGameResult();
		OutputView.printFirstPlayerResult(firstPlayerResult);
		OutputView.printSecondPlayerResult(secondPlayerResult);
	}

	private String calculate(Computer computerNumbers, Player Player) {
		return penaltyKickReferee.calculateResult(computerNumbers, Player);
	}

	private void createWinner(String firstPlayerResult, String secondPlayerResult) {
		long firstPlayerCount = penaltyKickReferee.resultCount(firstPlayerResult);
		long secondPlayerCount = penaltyKickReferee.resultCount(secondPlayerResult);
		OutputView.printWinner(firstPlayerCount, secondPlayerCount);
	}
}
