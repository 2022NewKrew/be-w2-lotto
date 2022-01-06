package domain.lotto;

import domain.prize.Prize;

import java.util.*;

import static java.util.stream.Collectors.*;

public class LottoTotalResult {

    private final List<LottoResult> lottoResults;
    private final int totalEarning;
    private final double earningRatio;

    public LottoTotalResult(List<LottoResult> lottoResults, int inputMoney) {
        this.lottoResults = lottoResults;
        this.totalEarning = lottoResults.stream()
                .mapToInt(LottoResult::getPrizeMoney)
                .sum();
        this.earningRatio = calculateEarningRatio(inputMoney);
    }

    private double calculateEarningRatio(int inputMoney) {
        return (totalEarning - inputMoney) / (double) inputMoney * 100;
    }

    public double getEarningRatio() {
        return earningRatio;
    }

    public Map<Prize, Long> getLottoTotalResultMap() {
        return lottoResults.stream()
                .collect(groupingBy(LottoResult::getPrizeType, counting()));
    }
}
