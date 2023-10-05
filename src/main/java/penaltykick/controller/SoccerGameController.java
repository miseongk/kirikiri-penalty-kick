package penaltykick.controller;

import java.io.IOException;
import java.util.List;

import penaltykick.domain.ComputerPosition;
import penaltykick.domain.GameResult;
import penaltykick.service.SoccerGameService;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class SoccerGameController {
	private SoccerGameService soccerGameService;

	public SoccerGameController() {
		OutputView.printStartFirstMessage();
		OutputView.printStartSecondMessage();
	}

	public void startSoccerGame() throws IOException {
		this.soccerGameService = new SoccerGameService();
		playGame();
	}

	private void playGame() throws IOException {
		List<Integer> computerPosition = new ComputerPosition().getComputerPosition();
		OutputView outputView = new OutputView(playerOneProcess(computerPosition), playerTwoProcess(computerPosition));
		outputView.printClearMessage();
		outputView.printGameResult();
	}

	private GameResult playerOneProcess(List<Integer> computerPos) throws IOException {
		GameResult playerOneResult;
		soccerGameService.initSoccerGame(computerPos);
		String playerOneInput = InputView.printInputPlayerOneMessage();
		playerOneResult = soccerGameService.compareTwoPosition(playerOneInput);
		return playerOneResult;
	}

	private GameResult playerTwoProcess(List<Integer> computerPos) throws IOException {
		GameResult playerTwoResult;
		soccerGameService.initSoccerGame(computerPos);
		String playerTwoInput = InputView.printInputPlayerTwoMessage();
		playerTwoResult = soccerGameService.compareTwoPosition(playerTwoInput);
		return playerTwoResult;
	}
}
