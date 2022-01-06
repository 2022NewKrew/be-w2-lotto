package domain;

import exception.InvalidLottoNumberException;

import java.util.List;

public class LottoWinningNumber extends Lotto {
    private final Integer bonus;

    public LottoWinningNumber(List<Integer> lotto, Integer bonus) {
        super(lotto);
        validateBonus(lotto, bonus);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    private void validateBonus(List<Integer> lotto, Integer bonus) {
        if (lotto.contains(bonus)) {
            throw new InvalidLottoNumberException(InvalidLottoNumberException.INVALID_BONUX_BALL);
        }

    }
}
