package penaltykick.utill;

import penaltykick.domain.Player;

import java.util.List;

import static penaltykick.utill.Reference.ERROR_MESSAGE;
import static penaltykick.utill.Reference.INPUT_COUNT;

public class Validation {

    public boolean checkRange(List<Integer> list) {
        for (int n : list)
            if (n > 3 || n < 1) {
                return false;
            }
        return true;
    }

    public boolean checkLength(List<Integer> list) {

        return list.size() == INPUT_COUNT;
    }

    public boolean isValid(List<Player> playerInput) {
        for (Player player : playerInput) {
            if(!checkRange(player.getDirectionList()) || !checkLength(player.getDirectionList())){
                return false;
            }
        }
        return true;
    }
}
