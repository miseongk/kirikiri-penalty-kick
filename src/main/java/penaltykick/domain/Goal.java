package penaltykick.domain;

public enum Goal {
    POSITION_LENGTH(5),
    LEFT(1),
    RIGHT(3);


    private final int value;

    private Goal(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
