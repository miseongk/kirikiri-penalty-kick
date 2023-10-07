package penaltykick;

public class Referee {
    // 플레이어와 컴퓨터의 순서값 비교
    public boolean isPlayerScoreGoal(int computer, int player){
        return computer != player;
    }

    void gameResult(int scoreP1, int scoreP2){
        if(scoreP1 > scoreP2){
            System.out.println("플레이어1이(가) 우승했습니다\uD83C\uDF89");
        } else if(scoreP1 < scoreP2){
            System.out.println("플레이어2이(가) 우승했습니다\uD83C\uDF89");
        } else{
            System.out.println("무승부입니다.");
        }
    }
}
