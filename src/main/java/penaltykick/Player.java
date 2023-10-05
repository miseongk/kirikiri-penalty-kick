package penaltykick;

import java.util.StringTokenizer;

public class Player {
    int[] player = new int[5];
    int score = 0;

    // player에게 입력받아 player[] 초기화
    public void playerInput(String input){
        StringTokenizer st =  new StringTokenizer(input);

        for(int i=0; i<5; i++){
            player[i] = Integer.parseInt(st.nextToken());
            checkInput(player[i]);
        }
    }
    // 적정 값 입력되지 않을 경우 IllegalArgumentException 발생
    void checkInput(int input){
        if ( input > 3 || input < 1) {
            throw new IllegalArgumentException("입력 값은 1~3의 숫자입니다.");
        }
    }

    void haveAGoal(){
        score++;
    }
}
