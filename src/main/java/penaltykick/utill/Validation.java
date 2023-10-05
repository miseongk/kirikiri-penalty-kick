package penaltykick.utill;

import penaltykick.domain.Player;

import java.util.List;

import static penaltykick.utill.Reference.*;

public class Validation {

    public void checkRange(List<Integer> list) {
        for (int n : list)
            if (n > 3 || n < 1){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
    }

    public void checkLength(List<Integer> list) {
        if (list.size() != INPUT_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public void isValid(List<Player> playerInput) {
        for (Player player : playerInput) {
            checkRange(player.getDirectionList());
            checkLength(player.getDirectionList());
        }
    }
}
