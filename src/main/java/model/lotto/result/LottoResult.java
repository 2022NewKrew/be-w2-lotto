package model.lotto.result;

import model.lotto.Lotto;
import model.lotto.LottoRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final Lotto winningLotto;
    private int revenuePercent;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.result = generateResult(lottos);
        this.revenuePercent = calculateRevenuePercent(lottos.size());
    }

    private Map<Integer, Integer> generateResult(List<Lotto> lottos) {
        List<LottoRank> lottoRanks = matchResults(lottos);
        return resultToMap(lottoRanks);
    }

    private Map<Integer, Integer> resultToMap(List<LottoRank> lottoRanks) {
        return lottoRanks
                .stream()
                .collect(Collectors.groupingBy(LottoRank::getReward, Collectors.summingInt(any-> 1)));
    }

    private List<LottoRank> matchResults(List<Lotto> lottos){
        return lottos
                .stream()
                .map(this::matchLotto)
                .collect(Collectors.toList());
    }

    private LottoRank matchLotto(Lotto lotto) {
        int numberOfSameNumber = countWinningNumberInLotto(lotto);
        return LottoRank.convertToLottoRank(numberOfSameNumber);
    }

    private int countWinningNumberInLotto(Lotto generatedLotto) {
        return winningLotto.countDuplicateNumberWith(generatedLotto);
    }

    private int calculateRevenuePercent(int numberOfLotto) {
        return revenuePercent = (int) Math.floor((double) getTotalEarn() / (numberOfLotto * Lotto.LOTTO_PRICE)  * 100);
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
