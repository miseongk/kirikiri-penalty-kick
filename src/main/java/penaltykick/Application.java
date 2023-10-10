package penaltykick;

import java.util.ArrayList;

public class Application {
    // [] 와 ,를 빼고 출력하게 하는 메소드
    private static void printArrayList(ArrayList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            printElement(i, list);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void printElement(int i, ArrayList<?> list) {
        System.out.print(list.get(i));
    }

    // OXList를 만드는 메서드
    private static ArrayList<String> OXListGenerator(ArrayList<Integer> playerNumberList, ArrayList<Integer> computerNumberList) {
        ArrayList<String> OXList = new ArrayList<>(); // 게임마다 초기화
        for (int i = 0; i < 5; i++) {
            ifPlayerAndComputerEqualsAddO(playerNumberList, computerNumberList, OXList, i);
            ifPlayerAndComputerNotEqualsAddX(playerNumberList, computerNumberList, OXList, i);
        }
        return OXList;
    }

    private static void ifPlayerAndComputerEqualsAddO(ArrayList<Integer> playerNumberList,
        ArrayList<Integer> computerNumberList, ArrayList<String> OXList, int i) {
        if (playerNumberList.get(i).equals(computerNumberList.get(i))) {
            OXList.add("O");
        }
    }

    private static void ifPlayerAndComputerNotEqualsAddX(ArrayList<Integer> playerNumberList,
        ArrayList<Integer> computerNumberList, ArrayList<String> OXList, int i) {
        if (!playerNumberList.get(i).equals(computerNumberList.get(i))) {
            OXList.add("X");
        }
    }

    // O의 개수를 카운트하는 메소드
    private static int OCounter(ArrayList<String> playerNumberList) {
        int count = 0;
        for (int i = 0; i < playerNumberList.size(); i++) {
            count = ifO_AddCount(playerNumberList, i, count);
        }
        return count;
    }

    private static int ifO_AddCount(ArrayList<String> playerNumberList, int i, int count) {
        if (playerNumberList.get(i).equals("O")) {
            count = count + 1;
        } return count;
    }

    private static void printPlayerAndArray(ArrayList<Integer> player1Number, ArrayList<Integer> player2Number) {
        System.out.println("플레이어1: ");
        printArrayList(player1Number);
        System.out.println("플레이어2: ");
        printArrayList(player2Number);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GoalKeeper goalKeeper = new GoalKeeper();
        Player player = new Player();
        Referee referee = new Referee();

        System.out.println("페널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 위치를 입력해주세요.");

        ArrayList<Integer> computerNumber = goalKeeper.computerRandomNumberGenerator(5);
        ArrayList<Integer> player1Number = player.playerNumberGenerator(5);
        ArrayList<Integer> player2Number = player.playerNumberGenerator(5);

        printPlayerAndArray(player1Number, player2Number);

        ArrayList<String> player1_OX_List = OXListGenerator(player1Number,computerNumber);
        ArrayList<String> player2_OX_List = OXListGenerator(player2Number,computerNumber);

        int player1_O_counts = OCounter(player1_OX_List);
        int player2_O_counts = OCounter(player2_OX_List);

        referee.winnerJudgement(player1_O_counts, player2_O_counts);

        System.out.println("게임 결과");
        System.out.print("플레이어1: ");
        printArrayList(player1_OX_List);
        System.out.print("플레이어2: ");
        printArrayList(player2_OX_List);

        referee.printWinner(player1_O_counts,player2_O_counts);
    }
}
