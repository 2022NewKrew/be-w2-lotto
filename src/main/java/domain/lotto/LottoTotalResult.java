package domain.lotto;

import domain.prize.Prize;

import java.util.*;

import static domain.prize.Prize.*;
import static java.util.stream.Collectors.*;

public class LottoTotalResult {

    private final List<LottoResult> lottoResults;
    private int totalEarning;
    private final double earningRatio;

    public LottoTotalResult(List<Integer> matchedList, int inputMoney) {
        lottoResults = new ArrayList<>();
        for (Integer matchedNum : matchedList) {
            createNewResult(matchedNum);
        }
        earningRatio = calculateEarningRatio(inputMoney);
    }

    private void createNewResult(int matchedNum) {
        LottoResult result = new LottoResult(matchedNum);
        if (result.getPrizeType() != NO_PRIZE) {
            totalEarning += result.getPrizeMoney();
            lottoResults.add(result);
        }
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
