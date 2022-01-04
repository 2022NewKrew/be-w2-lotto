package controller;

import model.lotto.DefinedLotto;
import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.RandomLotto;
import view.UserInput;
import view.UserOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private Lotto winningLotto;
    private final List<Lotto> lottos = new ArrayList<>();

    public void run() {
        long money = UserInput.getMoney();
        UserOutput.printBuyMessage(money / Lotto.LOTTO_PRICE);
        buyLottos(money);
        UserOutput.printLotto(lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList()));
        List<Integer> winningNumbers = UserInput.getWinningLotto();
        setWinningLotto(winningNumbers);
        UserOutput.printHistory(getResult());
        UserOutput.printRevenueRate(getTotalEarn() / money);
    }

    public void buyLottos(long money) {
        long numberOfLotto = money / Lotto.LOTTO_PRICE;
        for (long i = 0; i < numberOfLotto; i++) {
            buyLotto();
        }
    }

    public Map<LottoRank, Long> getResult() {
        List<LottoRank> lottoRanks = lottos.stream().map(this::matchLotto).collect(Collectors.toList());
        Map<LottoRank, Long> resultMap = new HashMap<>();
        for (LottoRank targetLottoRank : LottoRank.values()) {
            generateResult(resultMap, lottoRanks, targetLottoRank);
        }
        return resultMap;
    }

    public long getTotalEarn() {
        return getResult()
                .entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private void setWinningLotto(List<Integer> numbers) {
        winningLotto = new DefinedLotto(numbers);
    }

    private void buyLotto() {
        lottos.add(new RandomLotto());
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

    private void generateResult(Map<LottoRank, Long> result, List<LottoRank> lottoRanks, LottoRank targetLottoRank) {
        result.put(targetLottoRank, countLottoRank(lottoRanks, targetLottoRank));
    }

    private long countLottoRank(List<LottoRank> lottoRanks, LottoRank targetLottoRank) {
        return lottoRanks.stream()
                .filter(lottoRank -> lottoRank == targetLottoRank)
                .count();
    }
}
