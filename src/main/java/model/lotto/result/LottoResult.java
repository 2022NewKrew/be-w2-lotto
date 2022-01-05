package model.lotto.result;

import model.lotto.DefinedLotto;
import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.RandomLotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Integer, Integer> result;
    private final DefinedLotto winningLotto;
    private int revenuePercent;

    public LottoResult(List<RandomLotto> lottos, DefinedLotto winningLotto) {
        this.winningLotto = winningLotto;
        this.result = generateResult(lottos);
        this.revenuePercent = calculateRevenuePercent(lottos.size());
    }

    private Map<Integer, Integer> generateResult(List<RandomLotto> lottos) {
        List<LottoRank> lottoRanks = matchResults(lottos);
        return resultToMap(lottoRanks);
    }

    private Map<Integer, Integer> resultToMap(List<LottoRank> lottoRanks) {
        return lottoRanks
                .stream()
                .collect(Collectors.groupingBy(LottoRank::getReward, Collectors.summingInt(any-> 1)));
    }

    private List<LottoRank> matchResults(List<RandomLotto> lottos){
        return lottos
                .stream()
                .map(this::matchLotto)
                .collect(Collectors.toList());
    }

    private LottoRank matchLotto(RandomLotto lotto) {
        int numberOfSameNumber = countWinningNumberInLotto(lotto);
        return LottoRank.convertToLottoRank(numberOfSameNumber);
    }

    private int countWinningNumberInLotto(RandomLotto generatedLotto) {
        return winningLotto.countDuplicateNumberWith(generatedLotto.getLotto());
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
