package model.player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import utils.Utils;

public class PlayersBetMoney {

    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";

    private List<Integer> betMoneyList = new ArrayList<>();

    public void add(String betMoney) {
        validateBetMoney(Utils.deleteAllSpace(betMoney));
        betMoneyList.add(Integer.parseInt(Utils.deleteAllSpace(betMoney)));
    }

    public List<Integer> get() {
        return betMoneyList;
    }

    private void validateBetMoney(String betMoney) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, betMoney)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(betMoney) == 0) {
            throw new IllegalArgumentException();
        }
    }
}
