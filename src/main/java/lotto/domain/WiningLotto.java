package lotto.domain;

import lotto.result.LottoResult;

import java.util.List;

public class WiningLotto extends Lotto{

    private int bonusNumber;

    public WiningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

}
