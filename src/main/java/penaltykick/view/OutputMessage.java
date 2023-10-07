package penaltykick.view;

public class OutputMessage {
    public static void gameStartMessage() {
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.println("총 5번의 위치를 입력해주세요.");
    }
    public static void player1Message() {
        System.out.print("플레이어1 : ");
    }

    public static void player2Message() {
        System.out.print("플레이어2 : ");
    }

    public static void gameResultMessage() {
        System.out.println("게임 결과");
    }

    public static void Message(String messsage){
        System.out.println(messsage);
    }
}
