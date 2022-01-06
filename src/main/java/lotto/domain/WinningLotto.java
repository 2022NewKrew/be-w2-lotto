package lotto.domain;

import lotto.domain.constant.LottoMessage;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;
import lotto.domain.constant.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        super(winningNumbers);
        verifyBounds(bonusNumber);
        verifyDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void verifyDuplication(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
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
        numbers.retainAll(this.getNumbers());
        int numberOfMatches = numbers.size();
        return Rank.of(numberOfMatches, bonus);
    }
}
