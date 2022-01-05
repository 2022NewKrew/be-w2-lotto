package be.w2.lotto.domain.lottonumber;

import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.util.List;

import static be.w2.lotto.common.exception.ExceptionMessages.BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION;

public class BonusNumber extends LottoNumber {
    private BonusNumber(int number) {
        super(number);
    }

    public static BonusNumber valueOf(int bonusNumber, WinningLottoTicket winningLottoTicket) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber, winningLottoTicket);
        return new BonusNumber(bonusNumber);
    }

    public boolean isContainedIn(List<Integer> listedTicket) {
        return listedTicket.contains(this.number);
    }

    private static void validateDuplication(int bonusNumber, WinningLottoTicket winningLottoTicket)
            throws IllegalArgumentException
    {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION);
        }
    }
}
