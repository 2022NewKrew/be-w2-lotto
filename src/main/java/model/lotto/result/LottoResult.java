package model.lotto.result;

import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.WinningCondition;
import model.lotto.number.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final WinningCondition winningCondition;
    private int revenuePercent;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningCondition = new WinningCondition(winningLotto, bonusNumber);
        this.result = generateResult(lottos);
        this.revenuePercent = calculateRevenuePercent(lottos.size());
    }

    private Map<Integer, Integer> generateResult(List<Lotto> lottos) {
        return resultToMap(matchResults(lottos));
    }

    private Map<Integer, Integer> resultToMap(List<LottoRank> lottoRanks) {
        return lottoRanks
                .stream()
                .collect(Collectors.groupingBy(LottoRank::getReward, Collectors.summingInt(any -> 1)));
    }

    private List<LottoRank> matchResults(List<Lotto> lottos) {
        return lottos
                .stream()
                .map(winningCondition::compareTo)
                .collect(Collectors.toList());
    }

    private int calculateRevenuePercent(int numberOfLotto) {
        return revenuePercent = (int) Math.floor((double) getTotalEarn() / (numberOfLotto * Lotto.LOTTO_PRICE) * 100);
    }

    private int getTotalEarn() {
        return result
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public int getRevenuePercent() {
        return revenuePercent;
    }
}
