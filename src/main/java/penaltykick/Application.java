package penaltykick;

import java.util.ArrayList;

public class Application {
    // [] 와 ,를 빼고 출력하게 하는 메소드
    private static void printArrayList(ArrayList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }




    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GoalKeeper goalKeeper = new GoalKeeper();
        Player player = new Player();

        System.out.println("페널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 위치를 입력해주세요.");

        ArrayList<Integer> computerNumber = goalKeeper.computerRandomNumberGenerator(5);
        ArrayList<Integer> player1Number = player.playerNumberGenerator(5);
        ArrayList<Integer> player2Number = player.playerNumberGenerator(5);

        System.out.println("플레이어1: ");
        printArrayList(player1Number);
        System.out.println("플레이어2: ");
        printArrayList(player2Number);
    }
}
