package penaltykick;

import java.util.StringTokenizer;

public class Player {
    int[] player = new int[5];
    boolean[] scoreArr = new boolean[5];
    int score = 0;

    public Player(){

    }

    // player에게 입력받아 player[] 초기화
    public void playerInput(StringTokenizer input){

        for(int i=0; i<5; i++){
            player[i] = Integer.parseInt(input.nextToken());
            checkInput(player[i]);
        }
    }

    // 적정 값 입력되지 않을 경우 IllegalArgumentException 발생
    void checkInput(int input){
        if ( input > 3 || input < 1) {
            throw new IllegalArgumentException("입력 값은 1~3의 정수입니다.");
        }
    }

    void haveAGoal(){
        score++;
    }

    int getPlayerGoal(int index){
        return player[index];
    }

    void inputScoreArr(int index, boolean bool){
        if(bool) haveAGoal(); // 해당 부분은 이 메서드랑 상관 없는 로직이어서 빼야하는데 어떻게 빼야할지 잘 모르겠습니다...
        scoreArr[index] = bool;
    }

    String playerGameResult(){
        char[] arr = new char[5];
        for(int i=0; i<5; i++){
            if(scoreArr[i])
                arr[i] = 'O';
            else arr[i] = 'X';
        }
        return String.valueOf(arr);
    }

    int getScore(){
        // 자바 코드 컨벤션에는 getter/setter없이 작성하라는데, 해당 부분도 고민해야할 문제 같다.
        return score;
    }
}
