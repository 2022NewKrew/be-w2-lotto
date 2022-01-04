package domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Matching {

    private HashMap<Integer,Integer> matchMap = new HashMap<>();
    private int totalMatchMoney = 0;

    public void addMatchMap(int key)
    {
        addMatchMoney(key);
        if(matchMap.containsKey(key)) {
            matchMap.put(key, matchMap.get(key) + 1);
            return;
        }
        matchMap.put(key, 1);
    }
    private void addMatchMoney(int key) {
        switch (key)
        {
            case 3:
                totalMatchMoney += 5000;
                break;
            case 4:
                totalMatchMoney += 50000;
                break;
            case 5:
                totalMatchMoney += 1500000;
                break;
            case 6:
                totalMatchMoney += 2000000000;
                break;
        }
    }
    public int getMatchMoneyByKey(int key)
    {
        if(matchMap.containsKey(key)) {
            return matchMap.get(key);
        }
        return 0;
    }

    public int getTotalMatchMoney() {
        return totalMatchMoney;
    }
}
