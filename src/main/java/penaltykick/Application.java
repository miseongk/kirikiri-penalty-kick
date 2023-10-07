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
    }

    public static void getPlayerLocation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("플레이어1 : ");
        String input1 = br.readLine();
        player1Kick = input1.split(" ");

        System.out.print("플레이어2 : ");
        String input2 = br.readLine();
        player2Kick = input2.split(" ");
    }
}
