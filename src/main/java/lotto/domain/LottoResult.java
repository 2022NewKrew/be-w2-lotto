package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {

    private final Map<Reward, Integer> rewardCounter;

    public LottoResult(Map<Reward, Integer> rewardCounter) {
        this.rewardCounter = rewardCounter;
    }

    public Integer get(Reward reward) {
        return rewardCounter.getOrDefault(reward, 0);
    }

    public BigDecimal totalReward() {
        BigDecimal totalReward = BigDecimal.valueOf(0);
        for (Entry<Reward, Integer> entry : rewardCounter.entrySet()) {
            BigDecimal rewardPrize = BigDecimal.valueOf(entry.getKey().getRewardPrize());
            BigDecimal rewardCount = BigDecimal.valueOf(entry.getValue());
            totalReward = totalReward.add(rewardPrize.multiply(rewardCount));
        }
        return totalReward;
    }
}
