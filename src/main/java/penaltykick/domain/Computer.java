package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    private static Random random = new Random();
    private List <Integer> computer; // final을 써야하는지?

    public Computer() {
        computer = new ArrayList<>();
    }

    public List <Integer> computerPosition() {
        for(int i = 0; i < Goal.POSITION_LENGTH.getValue(); i++){
            int randomVal = Goal.LEFT.getValue() + random.nextInt(Goal.RIGHT.getValue());
            computer.add(randomVal);
        }
        return computer;
    }
}
