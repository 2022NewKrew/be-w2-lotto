package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
    }

<<<<<<< HEAD
=======
    public WinningLotto(Lotto lotto, Integer bonusNumber){
        super(lotto);
    }

>>>>>>> 73407950a993c8ab02b196cc1f9fecf44a984723
    public Integer getBonusNumber() {
        return this.bonusNumber;
    }


}
