package domain.lotto;

import domain.prize.Prize;

import java.util.*;

import static domain.prize.Prize.*;
import static java.util.stream.Collectors.*;

public class LottoTotalResult {

    private final List<LottoResult> lottoResults;
    private final double earningRatio;
    private int totalEarning;

    public LottoTotalResult(List<LottoResult> lottoResults, int inputMoney) {
        this.lottoResults = lottoResults;
        for (LottoResult lottoResult : lottoResults) {
            totalEarning += lottoResult.getPrizeMoney();
        }
        earningRatio = calculateEarningRatio(inputMoney);
    }

    private double calculateEarningRatio(int inputMoney) {
        return (totalEarning / (double) inputMoney) * 100;
    }

    public double getEarningRatio() {
        return earningRatio;
    }

    public Map<Prize, Long> getLottoTotalResultMap() {
        Map<Prize, Long> totalResultMap = lottoResults.stream()
                .collect(groupingBy(LottoResult::getPrizeType, counting()));

        for (Prize prize : List.of(FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE)) {
            totalResultMap.putIfAbsent(prize, 0L);
        }
        TreeMap<Prize, Long> totalResultTreeMap = new TreeMap<>(totalResultMap);
        return totalResultTreeMap.descendingMap();
    }

}
