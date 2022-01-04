package model.lottoResult;

import model.lotto.Lotto;
import model.lotto.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    Map<LottoRank, Long> result = new HashMap<>();
    Lotto winningLotto;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto) {
        this.winningLotto = winningLotto;
        generateResult(lottos, winningLotto);
    }

    private void generateResult(List<Lotto> lottos, Lotto winningLotto) {
        List<LottoRank> lottoRanks = lottos.stream().map(this::matchLotto).collect(Collectors.toList());
        for (LottoRank targetLottoRank : LottoRank.values()) {
            generateResult(result, lottoRanks, targetLottoRank);
        }
    }

    private void generateResult(Map<LottoRank, Long> result, List<LottoRank> lottoRanks, LottoRank targetLottoRank) {
        result.put(targetLottoRank, countLottoRank(lottoRanks, targetLottoRank));
    }

    private long countLottoRank(List<LottoRank> lottoRanks, LottoRank targetLottoRank) {
        return lottoRanks.stream()
                .filter(lottoRank -> lottoRank == targetLottoRank)
                .count();
    }

    private LottoRank matchLotto(Lotto lotto) {
        long numberOfSameNumber = countWinningNumberInLotto(lotto);
        return convertToLottoRank(numberOfSameNumber);
    }

    private long countWinningNumberInLotto(Lotto lotto) {
        return winningLotto.countDuplicateNumberWith(lotto);
    }

    private LottoRank convertToLottoRank(long numberOfSameNumber) {
        if (numberOfSameNumber == 6) {
            return LottoRank.FIRST_PRIZE;
        }
        if (numberOfSameNumber == 5) {
            return LottoRank.SECOND_PRIZE;
        }
        if (numberOfSameNumber == 4) {
            return LottoRank.THIRD_PRIZE;
        }
        if (numberOfSameNumber == 3) {
            return LottoRank.FORTH_PRIZE;
        }
        return LottoRank.FAIL;
    }

    public long getTotalEarn() {
        return result
                .entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Long> getResult() {
        return result;
    }
}
