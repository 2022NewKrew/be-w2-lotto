package lotto.domain.model;

import lotto.domain.constant.Prize;
import lotto.domain.constant.Rank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<Prize, Integer> winningResult;

    public LottoResult(List<Rank> rankList) {
        winningResult = new HashMap<>();
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.FAILED)
                .forEach(prize -> winningResult.put(prize, 0));
        rankList.stream()
                .map(rank -> Prize.of(rank))
                .forEach(prize -> winningResult.put(prize, winningResult.get(prize) + 1));
    }

    public double getEarningsRate(int investment) {
        BigInteger totalPrize = winningResult.entrySet().stream()
                .filter(item -> item.getValue() > 0)
                .map(item -> BigInteger.valueOf(item.getKey().getWinnings() * item.getValue()))
                .reduce(BigInteger.valueOf(0), (total, winnings) -> total.add(winnings));
        return (totalPrize.doubleValue() - (double) investment) / (new BigInteger(Integer.toString(investment))).doubleValue();
    }

    public Integer getCount(Prize prize) {
        return winningResult.get(prize);
    }
}
