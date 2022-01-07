package be.w2.lotto.domain.lottonumber;

import be.w2.lotto.common.exception.LottoNumberDuplicationNotAllowedException;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.util.List;

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
            throw new LottoNumberDuplicationNotAllowedException();
        }
    }
}
