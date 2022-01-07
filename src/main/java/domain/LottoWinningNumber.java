package domain;

import exception.InvalidLottoNumberException;

import java.util.List;
import java.util.Set;

public class LottoWinningNumber extends Lotto {
    private final Integer bonus;

    public LottoWinningNumber(Set<Integer> lotto, Integer bonus) {
        super(lotto);
        validateBonus(lotto, bonus);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    private void validateBonus(Set<Integer> lotto, Integer bonus) {
        if (lotto.contains(bonus)) {
            throw new InvalidLottoNumberException(InvalidLottoNumberException.INVALID_BONUX_BALL);
        }

    }
}
