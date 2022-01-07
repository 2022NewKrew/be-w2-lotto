package lotto.domain.model;

import lotto.domain.constant.LottoMessage;
import lotto.domain.constant.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {
    private long bonusNumber;

    public WinningLotto(List<Long> winningNumbers, Long bonusNumber) throws IllegalArgumentException {
        super(winningNumbers);
        verifyBounds(bonusNumber);
        verifyDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void verifyDuplication(List<Long> numbers, Long bonusNumber) throws IllegalArgumentException {
        Set<Long> numberSet = new HashSet<>(numbers);
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
        List<Long> numbers = lotto.getNumbers();
        boolean bonus = numbers.contains(bonusNumber);
        numbers.retainAll(this.getNumbers());
        long numberOfMatches = numbers.size();
        return Rank.of(numberOfMatches, bonus);
    }
}
