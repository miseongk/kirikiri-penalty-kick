package penaltykick;

import java.io.*;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] player1 = new int[5];
        int[] player2 = new int[5];
        StringTokenizer st;

        System.out.println("패널티 킥 게임을 시작합니다.\n" +
                            "총 5번의 위치를 입력해주세요.");

        // 플레이어 1, 2 입력 받기
        System.out.print("플레이어1 : ");
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            player1[i] = Integer.parseInt(st.nextToken());
            if ( player1[i] > 3 || player1[i] < 1) {
                throw new IllegalArgumentException("입력 값은 1~3의 숫자입니다.");
            }
        }
        System.out.print("플레이어2 : ");
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            player2[i] = Integer.parseInt(st.nextToken());
            if ( player2[i] > 3 || player2[i] < 1) {
                throw new IllegalArgumentException("입력 값은 1~3의 숫자입니다.");
            }
        }

        // 골키퍼(컴퓨터)가 랜덤으로 숫자 생성하기(5개)
        int[] computer = new int[5];
        for (int i = 0; i < 5; i++) {
            computer[i] = (int)(Math.random()*2)+1;
        }

        // 골키퍼(컴퓨터)와 플레이어들의 숫자를 비교하여 다르면 골 넣기 성공(O), 같으면 골 넣기 실패(X)
        Character[] resultP1 = new Character[5];
        Character[] resultP2 = new Character[5];
        int scoreP1 = 0;
        int scoreP2 = 0;
        for (int i = 0; i < 5; i++) {
            if (computer[i] == player1[i]) { // player1 실패
                resultP1[i] = 'X';
            } else { resultP1[i] = 'O';  scoreP1++; }// 성공

            if (computer[i] == player2[i]) { // player2 실패
                resultP2[i] = 'X';
            } else { resultP2[i] = 'O'; scoreP2++; }// 성공
        }

        // 게임 결과 출력
        System.out.println("\n게임 결과");
        System.out.print("플레이어1 : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(resultP1[i]);
        }
        System.out.println();
        System.out.print("플레이어2 : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(resultP2[i]);
        } System.out.println();

        if(scoreP1 > scoreP2){
            System.out.println("플레이어1이(가) 우승했습니다\uD83C\uDF89");
        } else if(scoreP1 < scoreP2){
            System.out.println("플레이어2이(가) 우승했습니다\uD83C\uDF89");
        } else{
            System.out.println("무승부입니다.");
        }

    }
}
