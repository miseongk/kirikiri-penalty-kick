package penaltykick;

import penaltykick.domain.Keeper;
import penaltykick.domain.Player;
import penaltykick.view.InputView;
import penaltykick.view.OutputView;

public class MainController {

	private final GameService service;

	public MainController(GameService service) {
		this.service = service;
	}

	public void run() {
		OutputView.printGameStart();
		Keeper computer = new Keeper(Utils.randomIntListInRange(1, 3, 5));
		Player player1 = new Player("플레이어1", InputView.readIntListWithDiv("플레이어1 : ", " "));
		Player player2 = new Player("플레이어2", InputView.readIntListWithDiv("플레이어2 : ", " "));
		Player winner = service.getWinner(computer, player1, player2);
		OutputView.printMessage("\n게임 결과");
		OutputView.printKickResult(player1, service.getKickResult(computer, player1));
		OutputView.printKickResult(player2, service.getKickResult(computer, player2));
		OutputView.printWinner(winner);
	}

}
