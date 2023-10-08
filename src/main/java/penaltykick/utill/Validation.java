package penaltykick.utill;

import penaltykick.domain.Player;

import java.util.List;

import static penaltykick.utill.Reference.*;

public class Validation {

    public boolean isValidNumber(List<Integer> list) {
        for (int n : list)
            if (n > MAXIMUM_NUMBER || n < MINIMUM_NUMBER) {
                return false;
            }
        return true;
    }
    public boolean isValidLength(List<Integer> list) {

        return list.size() == INPUT_COUNT;
    }

    public boolean isValid(List<Player> playerInput) {
        for (Player player : playerInput) {
            if(!isValidNumber(player.getDirectionList()) || !isValidLength(player.getDirectionList())){
                return false;
            }
        }
        return true;
    }
}
