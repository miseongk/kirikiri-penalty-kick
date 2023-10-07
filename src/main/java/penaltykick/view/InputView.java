package penaltykick.view;


import penaltykick.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static penaltykick.utill.Reference.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);


    public void readInputController(List<Player> list) {

        for (int i = 1; i <= PLAYER_COUNT; i++) {
            System.out.printf(PLAYER_MESSAGE, i);
            list.add(new Player(readInput()));
        }
    }

    public List<Integer> readInput() {
        String inputLine = SCANNER.nextLine();
        List<Integer> list = Arrays.stream(inputLine.split(CUT_CHARACTER))
                .map(this::parseInt)
                .collect(Collectors.toList());

        return list;
    }
    public int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void printError() {
        System.out.println(ERROR_MESSAGE);
    }
}
