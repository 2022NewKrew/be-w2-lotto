package domain.lotto;

import domain.prize.Prize;
import dto.LottoResultResponse;

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

    public LottoResultResponse toResponse() {
        Map<Prize, Long> totalResultMap = lottoResults.stream()
                .collect(groupingBy(LottoResult::getPrizeType, counting()));

        List<String> message = Prize.getTypeList().stream()
                .map(p -> getResultString(p, totalResultMap.getOrDefault(p, 0L)))
                .collect(toList());
        String totalRateOfReturn = String.format("%.2f", earningRatio);

        return new LottoResultResponse(message, totalRateOfReturn);
    }

    private String getResultString(Prize prize, long prizeCount) {
        if (prize.isMatchedBonus()) {
            return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개", prize.getMatchedNum(), prize.getPrizeMoney(), prizeCount);
        }
        return String.format("%s개 일치 (%s원)- %s개", prize.getMatchedNum(), prize.getPrizeMoney(), prizeCount);
    }
}

