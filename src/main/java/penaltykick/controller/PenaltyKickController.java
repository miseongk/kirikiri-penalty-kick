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

		String firstPlayerResult = calculate(computerNumbers, firstPlayer);
		String secondPlayerResult = calculate(computerNumbers, secondPlayer);

		printGameResult(firstPlayerResult, secondPlayerResult);

		createWinner(firstPlayerResult, secondPlayerResult);
	}

	private Computer createComputerNumber() {
		OutputView.printInputMessage();
		return generateComputer();
	}

	public Computer generateComputer() {
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
