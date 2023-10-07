package penaltykick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 위치를 입력해주세요.");

        System.out.print("플레이어1 : ");

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] inputArray1 = input1.split(" "); // [5,3]
        List<Integer> player1 = new ArrayList<>();
        //3.
        for (String a : inputArray1) {
            try {
                int number1 = Integer.parseInt(a);
                player1.add(number1);
            } catch (IllegalArgumentException e) {
                //4.
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                System.exit(1);
            }
        }

        System.out.print("플레이어2 : ");
        String input2 = sc.nextLine();
        String[] inputArray2 = input2.split(" ");
        List<Integer> player2 = new ArrayList<>();

        for (String b : inputArray2) {
            try {
                int number2 = Integer.parseInt(b);
                player2.add(number2);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                System.exit(1);
            }
        }

        /**
         * 1. 랜덤으로 5개 숫자 만들기
         * 2. 플레이어1이랑 컴퓨터 비교해서 OX만들기
         * 3. 플레이어2랑 컴퓨터 비교해서 OX만들기
         * 4. 결과 출력
         */

        //1.
        Random random = new Random();
        List<Integer> random_lst = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            random_lst.add(random.nextInt(3) + 1);
        }
        for (Integer i : random_lst) {
            System.out.print(i + " ");
        }
        System.out.println();
        //2.
        String result1 = "";
        int cnt1 = 0;
        for (int i = 0; i < 5; i++) {
            if (player1.get(i) != random_lst.get(i)) {
                result1 += "O";
                cnt1 += 1;
            } else {
                result1 += "X";
            }
        }
        //3
        String result2 = "";
        int cnt2 = 0;
        for (int i = 0; i < 5; i++) {
            if (player2.get(i) != random_lst.get(i)) {
                result2 += "O";
                cnt2 += 1;
            } else {
                result2 += "X";
            }
        }

        System.out.println("게임 결과");

        System.out.println("플레이어 1 : " + result1);
        System.out.println("플레이어 2 : " + result2);

        if (cnt1 > cnt2) {
            System.out.println("플레이어1이(가) 우승했습니다.");
        } else if (cnt1 < cnt2) {
            System.out.println("플레이어2이(가) 우승했습니다.");
        } else {
            System.out.println("무승부입니다.");
        }
    }
}
