package lottogame.domain;

import lottogame.exception.ErrorMessage;
import lottogame.exception.LotteryGameException;

public class WinningTicket {
    LotteryTicket winningTicket;
    LotteryNumber bonusNumber;

    public WinningTicket(LotteryTicket winningTicket, LotteryNumber bonusNumber) {
        validateDuplicate(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LotteryTicket winningTicket, LotteryNumber bonusNumber) {
        if (winningTicket.isContain(bonusNumber)) {
            throw new LotteryGameException(ErrorMessage.DUPLICATE_BONUS_BALL);
        }
    }

    public Rank rankTicket(LotteryTicket lotteryTicket) {
        return lotteryTicket.rankTicket(winningTicket, bonusNumber);
    }
}
