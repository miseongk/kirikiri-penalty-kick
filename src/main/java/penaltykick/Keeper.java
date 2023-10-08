package penaltykick;

import java.util.Random;

public class Keeper {
    private int[] saveDirection;

    public Keeper() {
        this.saveDirection = initRandomSaveDirection();
    }

    private static int[] initRandomSaveDirection() {
        Random random = new Random();
        int[] saved = new int[Constants.TOTAL_KICK];
        for (int i = 0; i < saved.length; i++) {
            saved[i] = random.nextInt(3) + 1;
        }
        return saved;
    }

    public int[] getSaveDirection() {
        return saveDirection;
    }
}
