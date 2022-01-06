package domain.lotto;

import domain.prize.Prize;

import java.util.*;

import static java.util.stream.Collectors.*;

public class LottoTotalResult {

    private final List<LottoResult> lottoResults;
    private final double earningRatio;
    private int totalEarning;

    public LottoTotalResult(List<LottoResult> lottoResults, int inputMoney) {
        this.lottoResults = lottoResults;
        for (LottoResult lottoResult : lottoResults) {
            this.totalEarning += lottoResult.getPrizeMoney();
        }
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
