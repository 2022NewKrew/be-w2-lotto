package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }


}
