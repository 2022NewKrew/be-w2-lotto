package lotto.domain;

import lotto.domain.constant.LottoMessage;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.constant.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public static LottoChecker getInstance() {
        return LazyHolder.lottoChecker;
    }

    private static class LazyHolder {
        private static final LottoChecker lottoChecker = new LottoChecker();
    }

    public void init(List<Integer> winningNumbers, int bonusNumber) {
        winningNumbers.forEach(this::verifyBounds);
        verifyBounds(bonusNumber);
        verifyDuplication(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void verifyBounds(int value) {
        if (1 > value || value > 45) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_OUT_OF_BOUND_ERROR.toString());
        }
    }

    private void verifyDuplication(List<Integer> numbers, int bonusNumber) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size() || numberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoMessage.NUMBER_DUPLICATED_ERROR.toString());
        }
    }

    public LottoResult checkAll(List<Lotto> lottoList) {
        List<Rank> rankList = lottoList.stream()
                .map(lotto -> checkLotto(lotto))
                .filter(rank -> rank != Rank.FAILED)
                .collect(Collectors.toList());
        return new LottoResult(rankList);
    }

    private Rank checkLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        boolean bonus = numbers.contains(bonusNumber);
        numbers.retainAll(winningNumbers);
        int numberOfMatches = numbers.size();
        return Rank.of(numberOfMatches, bonus);
    }

}
