package be.w2.lotto.result;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Result {
    private Map<Winnings, Integer> stat;

    public Result() {
        Map<Winnings, Integer> map = new EnumMap<>(Winnings.class);
        for (Winnings winnings : Winnings.values()) {
            map.put(winnings, 0);
        }
        this.stat = map;
    }

    public Map<Winnings, Integer> getStat() {
        return stat;
    }

    public void add(CorrectSpec correctSpec) {
        Optional<Winnings> optionalWinnings = Winnings.getWinningsByHowManyCorrect(correctSpec);
        optionalWinnings.ifPresent(
                rfc -> stat.put(rfc, stat.get(rfc) + 1)
        );
    }

    public int getRevenue() {
        int revenue = 0;
        for (Winnings winnings : stat.keySet()) {
            int howMany = stat.get(winnings);
            revenue += (howMany * winnings.getReward());
        }
        return revenue;
    }
}
