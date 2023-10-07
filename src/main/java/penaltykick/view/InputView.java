package penaltykick.view;

import penaltykick.domain.Goal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String PLAYER1 = "플레이어1 : ";
    private final static String PLAYER2 = "플레이어2 : ";
    private static List <Integer> player1 = new ArrayList<>();
    private static List <Integer> player2 = new ArrayList<>();

    public static List<Integer> getPlayer1() {
        return player1;
    }

    public static List<Integer> getPlayer2() {
        return player2;
    }

    Scanner scanner = new Scanner(System.in);

    public List <Integer> inputPlayer1(){
        System.out.print(PLAYER1);
        for(int i = 0; i < Goal.POSITION_LENGTH.getValue(); i++){
            int input = scanner.nextInt();
            player1.add(input);
        }
        return player1;
    }

    public List <Integer> inputPlayer2(){
        System.out.print(PLAYER2);
        for(int i = 0; i < Goal.POSITION_LENGTH.getValue(); i++){
            int input = scanner.nextInt();
            player2.add(input);
        }
        return player2;

    }
}
