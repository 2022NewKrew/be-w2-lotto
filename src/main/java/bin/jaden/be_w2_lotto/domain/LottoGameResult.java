package bin.jaden.be_w2_lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    final List<String> message;
    final long totalRateOfReturn;

    public LottoGameResult(Map<LottoRankEnum, Integer> resultMap, int purchasingAmount) {
        List<String> message = new ArrayList<>();
        long totalRewards = 0;
        for (int i = 3; i <= 7; i++) {
            LottoRankEnum rank = LottoRankEnum.values()[i - 2];
            int count = resultMap.getOrDefault(rank, 0);
            message.add(rank.getPrintString(count));
            totalRewards += (long) rank.getReward() * count;
        }
        this.message = Collections.unmodifiableList(message);
        totalRateOfReturn = (totalRewards - purchasingAmount) * 100 / purchasingAmount;
    }

    public List<String> getMessage() {
        return message;
    }

    public long getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
