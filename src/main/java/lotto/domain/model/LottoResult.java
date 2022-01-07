package lotto.domain.model;

import lotto.domain.constant.Prize;
import lotto.domain.constant.Rank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Long> winningResult;

    public LottoResult(List<Rank> rankList) {
        winningResult = new HashMap<>();
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.FAILED)
                .forEach(prize -> winningResult.put(prize, 0L));
        rankList.stream()
                .map(Prize::of)
                .forEach(prize -> winningResult.put(prize, winningResult.get(prize) + 1));
    }

    public long getEarningsPercent(Long investment) {
        BigInteger totalPrize = winningResult.entrySet().stream()
                .filter(item -> item.getValue() > 0)
                .map(item -> BigInteger.valueOf(item.getKey().getWinnings() * item.getValue()))
                .reduce(BigInteger.valueOf(0), (total, winnings) -> total.add(winnings));
        double rate = (totalPrize.doubleValue() - (double) investment) / BigInteger.valueOf(investment).doubleValue();
        return Math.round(rate * 100);
    }

    public Long getCount(Prize prize) {
        return winningResult.get(prize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.FAILED)
                .forEach(prize -> {
                    sb.append(String.format(
                            "%d개 일치%s(%d원) - %d개",
                            prize.getRank().getNumberOfMatches(),
                            prize.getRank().getBonus() ? ", 보너스 볼 일치" : "",
                            prize.getWinnings(),
                            this.getCount(prize)
                    ));
                    sb.append("\n");
                });
        return sb.toString();
    }
}
