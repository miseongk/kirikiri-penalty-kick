package penaltykick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static Integer[] goalkeeperKick = new Integer[5];

    public static void main(String[] args) throws IOException {
        String result1;
        String result2;
        Integer[] player1Kick = new Integer[5];
        Integer[] player2Kick = new Integer[5];

        System.out.println("패널티 킥 게임을 시작합니다.");

        makeGoalkeeperKick();

        System.out.println("총 5번의 위치를 입력해주세요.");
        getPlayerLocation(player1Kick, player2Kick);

        System.out.println("");
        System.out.println("게임 결과");

    }

    /**
     * 골키퍼의 패널티 킥 위치 랜덤 생성
     */
    public static void makeGoalkeeperKick() {
        for(int i = 0; i < 5; i++) {
            goalkeeperKick[i] = (int)((Math.random() * 3) + 1);
        }
    }

    /**
     * 플레이어1과 플레이어2의 패널티 킥 위치 입력받기
     */
    public static void getPlayerLocation(Integer[] player1Kick, Integer[] player2Kick) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] player1KickTemp;
        String[] player2KickTemp;

        System.out.print("플레이어1 : ");
        String input1 = br.readLine();

        try {
            player1KickTemp = input1.split(" ");
        } catch (Exception exception) {
            IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
            throw e;
        }
        checkIfValueIsNormal(player1KickTemp, player1Kick);

        System.out.print("플레이어2 : ");
        String input2 = br.readLine();
        try {
            player2KickTemp = input2.split(" ");
        } catch (Exception exception) {
            IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
            throw e;
        }
        checkIfValueIsNormal(player2KickTemp, player2Kick);
    }

    /**
     * 입력된 값이 정상적인지 검사 : 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 프로그램 종료시키기
     */
    public static void checkIfValueIsNormal(String[] tempKicks, Integer[] kicks) {
        int index = 0;
        try {
            for (String kick : tempKicks) {
                int kickNumber = Integer.parseInt(kick);
                if ((kickNumber < 1) || (kickNumber > 3)) {
                    IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
                    throw e;
                } else {
                    kicks[index++] = kickNumber;
                }
            }
        } catch (NumberFormatException numberFormatException) {
            IllegalArgumentException e = new IllegalArgumentException("예외 발생시 IllegalArgumentException으로 통합");
            throw e;
        }
    }

    /**
     * 골 여부 구하기
     */
    public static void findOutIfIsGoal() {

    }
}
