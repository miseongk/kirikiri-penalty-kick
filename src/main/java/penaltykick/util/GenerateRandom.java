package penaltykick.util;

import java.util.Random;

public class GenerateRandom {

    private final Random random;
    private final Integer START = 1;
    private final Integer END = 3;

    public GenerateRandom() {
        random = new Random();
    }
    public int getNumber() {
        return START + random.nextInt(END);
    }


}
