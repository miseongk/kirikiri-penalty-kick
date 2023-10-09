package penaltykick;

import penaltykick.controller.GameController;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController(scanner);
        gameController.play();
    }
}
