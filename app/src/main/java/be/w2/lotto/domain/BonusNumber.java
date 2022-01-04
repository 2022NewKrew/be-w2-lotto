package be.w2.lotto.domain;

import java.util.List;

import static be.w2.lotto.common.exception.ExceptionMessages.BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber valueOf(int bonusNumber, WinningLottoTicket winningLottoTicket) {
        validateBonusNumber(bonusNumber, winningLottoTicket);
        return new BonusNumber(bonusNumber);
    }

    public boolean isContainedIn(List<Integer> listedTicket) {
        return listedTicket.contains(this.number);
    }

    private static void validateBonusNumber(int bonusNumber, WinningLottoTicket winningLottoTicket)
            throws IllegalArgumentException
    {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION);
        }
    }
}
