package penaltykick;

import penaltykick.config.GameConfig;
import penaltykick.controller.GameController;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig(new GameController());
        gameConfig.set();
        gameConfig.gameStart();
    }
}
