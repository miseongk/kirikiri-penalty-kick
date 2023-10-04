package penaltykick;

import java.io.*;

public class Application {
    static int playerNum=2; // 총 플레이어 수
    static int shootingNum=5; // 각 플레이어의 슈팅 횟수

    // 시작 출력문구
    static void printOpeningPhrase(){
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 "+shootingNum+"번의 위치를 입력해주세요.");
    }

    public static void main(String[] args) throws IOException{

        // 시작문구 출력
        printOpeningPhrase();

    }
}
