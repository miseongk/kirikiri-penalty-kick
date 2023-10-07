package penaltykick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static String[] player1Kick;
    static String[] player2Kick;

    public static void main(String[] args) throws IOException {
        String result1;
        String result2;
        System.out.print("패널티 킥 게임을 시작합니다.\n총 5번의 위치를 입력해주세요.\n");

        getPlayerLocation();

        System.out.println("");
        System.out.println("게임 결과");
    }

    public static void getPlayerLocation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("플레이어1 : ");
        String input1 = br.readLine();

        try {
            player1Kick = input1.split(" ");
        } catch (Exception exception) {
            IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
            throw e;
        }
        checkIfValueIsNormal(player1Kick);

        System.out.print("플레이어2 : ");
        String input2 = br.readLine();
        try {
            player2Kick = input2.split(" ");
        } catch (Exception exception) {
            IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
            throw e;
        }
        checkIfValueIsNormal(player2Kick);
    }

    public static void checkIfValueIsNormal(String[] kickArray) {
        try {
            for (String kick : kickArray) {
                int kickNumber = Integer.parseInt(kick);
                if ((kickNumber < 1) || (kickNumber > 3)) {
                    IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
                    throw e;
                }
            }
        } catch (NumberFormatException numberFormatException) {
            IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
            throw e;
        }
    }
}
