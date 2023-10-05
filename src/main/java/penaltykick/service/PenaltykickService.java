package penaltykick.service;

import java.util.ArrayList;
import java.util.List;

public class PenaltykickService {
    private static final int KICK_NUMBER = 5;
    public static List<Integer> makeRandomNumberList() {
        List<Integer> randomList = new ArrayList<>(KICK_NUMBER);
        for(int i = 0; i < KICK_NUMBER; i++) {
            randomList.add((int)(Math.random() * 3) + 1);
        }
        return randomList;
    }
}
