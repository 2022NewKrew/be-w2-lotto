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

    public int checkMatchedNumbers(Lotto autoLotto, Set<Integer> inputLastWeekWinNumbers) {
        return (int) inputLastWeekWinNumbers.stream()
                .filter(inputLastWeekWinNumber -> checkMatchedNumber(autoLotto, inputLastWeekWinNumber))
                .count();
    }

    private Boolean checkMatchedNumber(Lotto autoLotto, Integer inputLastWeekWinNumber) {
        return autoLotto.getLotto().stream()
                .anyMatch(autoLottoNumber -> (autoLottoNumber.equals(inputLastWeekWinNumber)));
    }

    private void validateBonus(Set<Integer> lotto, Integer bonus) {
        if (lotto.contains(bonus)) {
            throw new InvalidLottoNumberException(InvalidLottoNumberException.INVALID_BONUS_BALL);
        }

    }
}
