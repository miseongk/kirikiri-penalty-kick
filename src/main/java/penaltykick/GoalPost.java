package penaltykick;

/**
 * 골대
 * 골키퍼의 위치 또는 킥의 위치를 책임집니다.
 */
public class GoalPost {
    private final Location location;

    public GoalPost(int number) {
        this.location = getLocationFromNumber(number);
    }

    public Location getLocation() {
        return location;
    }

    /**
     * 왼쪽 가운데 오른쪽 이외의 값에는 에러를 반환합니다.
     */
    private Location getLocationFromNumber(int number) {
        switch (number) {
            case 1: return Location.LEFT;
            case 2: return Location.MIDDLE;
            case 3: return Location.RIGHT;
            default:
                throw new IllegalArgumentException("골대 범위를 나갔습니다.");
        }
    }
}
