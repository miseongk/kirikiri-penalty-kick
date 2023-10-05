package penaltykick.model;

import java.util.*;
public class Player {
    private final List<Integer> numberList;

    public Player(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
