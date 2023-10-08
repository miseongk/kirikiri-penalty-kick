package penaltykick.domain;

import java.util.ArrayList;
import java.util.Random;

public class Goalkeeper {
    private static final int RANDOM_MAX_NUMBER = 3;

    ArrayList<Integer> goalkeeperRandomNumber = new ArrayList<>();

    public Goalkeeper() {
        this.goalkeeperRandomNumber = makeRandomNumber();
    }

    private ArrayList<Integer> makeRandomNumber() {
        Random random = new Random();
        ArrayList<Integer> randomNumber = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            randomNumber.add(random.nextInt(RANDOM_MAX_NUMBER) + 1);
        }
        return randomNumber;
    }

    public ArrayList<Integer> getGoalkeeperRandomNumber() {
        return goalkeeperRandomNumber;
    }
}
