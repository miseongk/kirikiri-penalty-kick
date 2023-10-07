package penaltykick;

import java.io.IOException;

import penaltykick.controller.SoccerGameController;

public class Application {
	public static void main(String[] args) throws IOException {
		SoccerGameController game = new SoccerGameController();
		game.startSoccerGame();
	}
}
