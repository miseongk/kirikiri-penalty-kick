package penaltykick;

public class Player {
    private int id;
    private String[] score;
    private int[] kickDirection;

    public Player(int id) {
        this.id = id;
        this.score = new String[Constants.TOTAL_KICK];
        this.kickDirection = new int[Constants.TOTAL_KICK];
    }

    public void savedKick(int[] kicked) {
        for (int i = 0; i < kicked.length; i++) {
            kickDirection[i] = determineKick(kicked[i]);
        }
    }

    private int determineKick(int kick) {
        switch (kick) {
            case 1:
                return Constants.KICK_LEFT;
            case 2:
                return Constants.KICK_MIDDLE;
            case 3:
                return Constants.KICK_RIGHT;
            default:
                throw new IllegalArgumentException("올바른 킥의 방향을 입력해 주세요.");
        }
    }

    public int getId() {
        return id;
    }

    public int[] getKickDirection() {
        return kickDirection;
    }

    public String[] getScore() {
        return score;
    }

    public void setScore(String[] score) {
        this.score = score;
    }
}

