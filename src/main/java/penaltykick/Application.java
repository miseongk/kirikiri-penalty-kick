package penaltykick;

import penaltykick.controller.SoccerGameController;

public class Application {
	public static void main(String[] args) {
		SoccerGameController game = new SoccerGameController();
		game.playGame();
	}
}
