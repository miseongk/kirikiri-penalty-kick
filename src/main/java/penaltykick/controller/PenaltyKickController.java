package penaltykick.controller;

import java.util.ArrayList;
import java.util.List;

import penaltykick.domain.Computer;
import penaltykick.domain.NumberGenerator;
import penaltykick.domain.PenaltyKickReferee;
import penaltykick.domain.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class PenaltyKickController {

	private static final int REPEAT_NUMBER = 5;

	private final PenaltyKickReferee penaltyKickReferee;
	private final NumberGenerator numberGenerator;

	public PenaltyKickController(PenaltyKickReferee penaltyKickReferee, NumberGenerator numberGenerator) {
		this.penaltyKickReferee = penaltyKickReferee;
		this.numberGenerator = numberGenerator;
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

		List<Boolean> firstPlayerResult = calculate(computerNumbers, firstPlayer);
		List<Boolean> secondPlayerResult = calculate(computerNumbers, secondPlayer);

		printGameResult(firstPlayerResult, secondPlayerResult);
	}

	private Computer createComputerNumber() {
		OutputView.printInputMessage();
		return generateComputer();
	}

	private Computer generateComputer() {
		List<Integer> computerNumber = generateRandomNumber();
		return new Computer(computerNumber);
	}

	private List<Integer> generateRandomNumber() {
		List<Integer> computerNumber = new ArrayList<>();
		for (int i = 0; i < REPEAT_NUMBER; i++) {
			computerNumber.add(numberGenerator.generate());
		}
		return computerNumber;
	}

	private Player createPlayer() {
		List<Integer> playerNumbers = InputView.readPlayerNumber();
		return new Player(playerNumbers);
	}

	private void printGameResult(List<Boolean> firstPlayerResult, List<Boolean> secondPlayerResult) {
		OutputView.printGameResult();
		OutputView.printCalculateResult(firstPlayerResult);
		OutputView.printCalculateResult(secondPlayerResult);
		createWinner(firstPlayerResult, secondPlayerResult);
	}

	private List<Boolean> calculate(Computer computer, Player player) {
		return computer.calculateResult(player);
	}

	private void createWinner(List<Boolean> firstPlayerResult, List<Boolean> secondPlayerResult) {
		long firstPlayerCount = penaltyKickReferee.resultCount(firstPlayerResult);
		long secondPlayerCount = penaltyKickReferee.resultCount(secondPlayerResult);
		OutputView.printWinner(firstPlayerCount, secondPlayerCount);
	}
}
