package penaltykick.service;

import java.util.ArrayList;

public class Service {
    public int countGoal(ArrayList<Integer> lst1, ArrayList<Integer> lst2) {
        int cnt = 0;
        for (int i=0;i<5;i++) {
            if (lst1.get(i) != lst2.get(i)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public String resultOfGoal(ArrayList<Integer> lst1,ArrayList<Integer> lst2) {
        String goal = "";
        for (int i=0;i<5;i++) {
            if (lst1.get(i) != lst2.get(i)) {
                goal += "O";
            }else {
                goal += "X";
            }
        }
        return goal;
    }

    public String gameResult(int player1Score, int player2Score) {
        String result = "무승부 입니다.";

        if(player1Score > player2Score) {
            result = "플레이어1이(가) 우승했습니다.";
        }else if (player1Score < player2Score) {
            result = "플레이어2이(가) 우승했습니다.";
        }
        return result;
    }
}
