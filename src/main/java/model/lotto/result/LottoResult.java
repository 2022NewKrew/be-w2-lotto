package model.lotto.result;

import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.number.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final Lotto winningLotto;
    private int revenuePercent;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.result = generateResult(lottos, bonusNumber);
        this.revenuePercent = calculateRevenuePercent(lottos.size());
    }

    private Map<Integer, Integer> generateResult(List<Lotto> lottos, LottoNumber bonusNumber) {
        List<LottoRank> lottoRanks = matchResults(lottos, bonusNumber);
        return resultToMap(lottoRanks);
    }

    private Map<Integer, Integer> resultToMap(List<LottoRank> lottoRanks) {
        return lottoRanks
                .stream()
                .collect(Collectors.groupingBy(LottoRank::getReward, Collectors.summingInt(any -> 1)));
    }

    private List<LottoRank> matchResults(List<Lotto> lottos, LottoNumber bonusNumber) {
        return lottos
                .stream()
                .map(lotto -> matchLotto(lotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private LottoRank matchLotto(Lotto lotto, LottoNumber bonusNumber) {
        return LottoRank.convertToLottoRank(winningLotto.contain(lotto), lotto.contain(bonusNumber));
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
