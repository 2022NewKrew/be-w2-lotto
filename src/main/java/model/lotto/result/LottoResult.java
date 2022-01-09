package model.lotto.result;

import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.WinningCondition;
import model.lotto.number.LottoNumber;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<LottoRank, Integer> result;
    private final WinningCondition winningCondition;
    private int revenuePercent;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningCondition = new WinningCondition(winningLotto, bonusNumber);
        this.result = generateResult(lottos);
        this.revenuePercent = calculateRevenuePercent(lottos.size());
    }

    private Map<LottoRank, Integer> generateResult(List<Lotto> lottos) {
        return resultToMap(matchResults(lottos));
    }

    private Map<LottoRank, Integer> resultToMap(List<LottoRank> results) {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, countOfTargetLottoRank(results, lottoRank));
        }
        return result;
    }

    private int countOfTargetLottoRank(List<LottoRank> results, LottoRank targetLottoRank) {
        return (int) results
                .stream()
                .filter(targetLottoRank::equals)
                .count();
    }

    private List<LottoRank> matchResults(List<Lotto> lottos) {
        return lottos
                .stream()
                .map(winningCondition::confirmLotto)
                .collect(Collectors.toList());
    }

    private int calculateRevenuePercent(int numberOfLotto) {
        return revenuePercent = (int) Math.floor(((double) getTotalEarn() / (numberOfLotto * Lotto.LOTTO_PRICE)) * 100);
    }

    private int getTotalEarn() {
        return result
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int getRevenuePercent() {
        return revenuePercent;
    }
}
