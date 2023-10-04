package penaltykick;

import java.util.List;

public class MainController {

	private final GameService service;

	public void run() {
		OutputVIew.printGameStart();
		Keeper computer = new Keeper(Utils.randomIntListInRange(1, 3, 5));
		Player player1 = new Player(InputView.readIntWithDiv("플레이어1 : ", " "));
		Player player2 = new Player(InputView.readIntWithDiv("플레이어2 : ", " "));
		Player winner = service.getWinner(computer, player1, player2);
		OutputView.printFinalResult(winner);
	}

	private void gameInit() {

	}
}
