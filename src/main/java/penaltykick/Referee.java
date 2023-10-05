package penaltykick;

public class Referee {
    // 플레이어와 컴퓨터의 순서값 비교
    public boolean isPlayerScoreGoal(int computer, int player){
        if(computer == player){
            return false;
        } else{
            return true;
        }
    }
}
