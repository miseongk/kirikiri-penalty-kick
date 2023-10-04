package penaltykick;

import java.io.*;
import java.util.StringTokenizer;

public class Application {
    static int playerNum=2; // 총 플레이어 수
    static int shootingNum=5; // 각 플레이어의 슈팅 횟수
    static int playerKick[][]; // 플레이어가 슈팅할 방향 저장
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 시작 출력문구
    static void printOpeningPhrase(){
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 "+shootingNum+"번의 위치를 입력해주세요.");
    }

    // 플레이어 슈팅 방향 입력
    static void insertShooting(int num) throws IOException {
        System.out.print("플레이어"+num+" : ");
        String command = br.readLine();
        StringTokenizer st = new StringTokenizer(command);
        for(int i=0;i<shootingNum;++i){
            playerKick[num-1][i]=Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException{

        // 플레이어 슈팅 방향 및 키퍼 선방 방향 값을 담은 배열 크기 설정
        playerKick = new int[playerNum][shootingNum];

        // 시작문구 출력
        printOpeningPhrase();

        // 플레이어 슈팅 방향 입력
        for(int i=1;i<=playerNum;++i) insertShooting(i);

    }
}
