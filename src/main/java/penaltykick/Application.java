package penaltykick;

public class Application {

    private static final int NUMBER_OF_PLAYERS = 2; //참가하는 플레이어 인원수
    private static final int NUMBER_OF_GOALS = 5; //패널티킥의 수

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("패널티 킥 게임을 시작합니다.");
        System.out.printf("총 %d번의 위치를 입력해주세요.%n", NUMBER_OF_GOALS);

        PlayerProvider playerProvider = new PlayerProvider(NUMBER_OF_PLAYERS,NUMBER_OF_GOALS);
        Player[] players = playerProvider.playerShootGoal(); //유저들의 패널티 킥을 입력받습니다.

        Goalkeeper goalkeeper = new Goalkeeper(NUMBER_OF_GOALS);
        goalkeeper.catchTheBall(); //골키퍼의 수비

        System.out.println("게임결과");
        Referee referee = new Referee();
        referee.printGoalStatus(players, goalkeeper);
    }
}
