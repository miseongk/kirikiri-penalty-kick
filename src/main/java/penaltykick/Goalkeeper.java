package penaltykick;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 골키퍼
 * 랜덤으로 골대의 위치 부분에 서있는다.
 */
public class Goalkeeper {
    private final GoalPost[] catchPositionArr; //골키퍼 수비 방향

    public Goalkeeper(int totalNumberOfGoal){
        catchPositionArr = new GoalPost[totalNumberOfGoal];
    }

    /**
     * 골키퍼는 랜덤으로 골대에 서서 패널티킥을 막습니다.
     */
    public void catchTheBall(){
        for (int i = 0; i < catchPositionArr.length; i++) {
            catchPositionArr[i] = new GoalPost(generateRandomNumberInRange());
        }
    }

    public GoalPost[] getCatchPositionArr() {
        return catchPositionArr.clone();
    }

    private int generateRandomNumberInRange() {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            return random.nextInt(Location.RIGHT.getNumber()) + Location.LEFT.getNumber();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException 오류");
        }
    }
}
