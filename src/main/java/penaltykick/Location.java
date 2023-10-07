package penaltykick;

public enum Location {
    LEFT(1),
    MIDDLE(2),
    RIGHT(3);

    private final int number;

    Location(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
