package penaltykick;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Application {
    static final int playerNum=2; // 총 플레이어 수
    static final int shootingNum=5; // 각 플레이어의 슈팅 횟수
    static int playerKick[][]; // 플레이어가 슈팅할 방향 저장
    static int kipperDirection[]; // 키퍼가 막을 방향 저장
    static int maxGoalCount=0; // 최대 골 수 저장
    static int winner=0; // 승자 플레이어 번호 저장
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
        validate(command);
        StringTokenizer st = new StringTokenizer(command);
        for(int i=0;i<shootingNum;++i){
            playerKick[num-1][i]=Integer.parseInt(st.nextToken());
        }
    }

    // 슈팅 방향 입력 예외처리
    static void validate(String command){
        StringTokenizer tempst = new StringTokenizer(command);
        if(tempst.countTokens()!=shootingNum) throw new IllegalArgumentException(shootingNum+"개의 수를 입력해주세요.");

        for(int i=0;i<shootingNum;++i){
            int val=Integer.parseInt(tempst.nextToken());
            if(val!=1 && val!=2 && val!=3) throw new IllegalArgumentException("잘못된 슈팅 방향이 입력되었습니다.");
        }
    }

    // 랜덤 골키퍼 방향 설정
    static void configKipperDirection(){
        Random rd = new Random();
        for(int i=0;i<shootingNum;++i){
            kipperDirection[i]=(rd.nextInt(3)+1);
        }
    }

    // 슈팅 결과 출력
    static void shooutingResult(int num){
        int successCount=0;
        System.out.print("플레이어"+num+" : ");
        for(int i=0;i<shootingNum;++i){
            if(kipperDirection[i]!=playerKick[num-1][i]){
                ++successCount;
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
        }
        System.out.println();

        if(maxGoalCount<successCount){
            maxGoalCount=successCount;
            winner=num;
        }
    }

    public static void main(String[] args) throws IOException{

        // 플레이어 슈팅 방향 및 키퍼 선방 방향 값을 담은 배열 크기 설정
        playerKick = new int[playerNum][shootingNum];
        kipperDirection = new int[shootingNum];

        // 시작문구 출력
        printOpeningPhrase();

        // 플레이어 슈팅 방향 입력
        for(int i=1;i<=playerNum;++i) insertShooting(i);

        // 랜덤 골키퍼 방향 설정
        configKipperDirection();

        // 플레이어별 슈팅 결과 출력
        System.out.println("\n게임 결과");
        for(int i=1;i<=playerNum;++i) shooutingResult(i);
        System.out.println("플레이어"+winner+"이(가) 우승했습니다\uD83C\uDF89");

    }
}
