package model;

import java.util.ArrayList;
import java.util.List;

public class PlayersBetMoney {

    private List<String> betMoneyList = new ArrayList<>();

    public void add(String betMoney) {
        betMoneyList.add(betMoney);
    }

    public List<String> get() {
        return betMoneyList;
    }
}
