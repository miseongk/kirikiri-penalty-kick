package penaltykick;

/**
 * 플레이어제공자
 * 플레이어를 제공해주는 책입을 집니다.
 */
public class PlayerProvider {
    private final int totalNumberOfPlayer; //플레이어 총 수
    private final int totalNumberOfGoal; //골을 찰 수 있는 기회

    public PlayerProvider(int totalNumberOfPlayer, int totalNumberOfGoal) {
        this.totalNumberOfPlayer = totalNumberOfPlayer;
        this.totalNumberOfGoal = totalNumberOfGoal;
    }

    /**
     * 플레이어들의 패널티킥을 입력받습니다..
     */
    public Player[] playerShootGoal() {
        Player[] players = new Player[totalNumberOfPlayer];
        for (int i = 0; i < totalNumberOfPlayer; i++) {
            Player player = new Player(i + 1, totalNumberOfGoal);
            player.kickIntoGoal();
            players[i] = player;
        }
        return players;
    }
}
