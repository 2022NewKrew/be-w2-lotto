package be.w2.lotto.result;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Result {
    private Map<RewardForCorrect, Integer> stat;

    public Result() {
        Map<RewardForCorrect, Integer> map = new EnumMap<>(RewardForCorrect.class);
        for (RewardForCorrect rewardForCorrect : RewardForCorrect.values()) {
            map.put(rewardForCorrect, 0);
        }
        this.stat = map;
    }

    public Map<RewardForCorrect, Integer> getStat() {
        return stat;
    }

    public void add(int howManyCorrect) {
        Optional<RewardForCorrect> rewardForCorrect = getRewordForCorrctByHowManyCorrect(howManyCorrect);
        rewardForCorrect.ifPresent(
                rfc -> stat.put(rfc, stat.get(rfc) + 1)
        );
    }

    private Optional<RewardForCorrect> getRewordForCorrctByHowManyCorrect(int howManyCorrect) {
        for (RewardForCorrect rewardForCorrect : RewardForCorrect.values()) {
            if (rewardForCorrect.getHowManyCorrect() == howManyCorrect)
                return Optional.of(rewardForCorrect);
        }
        return Optional.empty();
    }

    public int getRevenue() {
        int revenue = 0;
        for (RewardForCorrect rewardForCorrect : stat.keySet()) {
            int howMany = stat.get(rewardForCorrect);
            revenue += (howMany * rewardForCorrect.getReward());
        }
        return revenue;
    }
}
