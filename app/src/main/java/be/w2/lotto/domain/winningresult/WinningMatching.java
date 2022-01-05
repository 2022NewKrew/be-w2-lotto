package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTicket;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.util.List;

import static be.w2.lotto.common.exception.ExceptionMessages.FORBIDDEN_INSTANCE_GENERATION_EXCEPTION;

public class WinningMatching {
    private WinningMatching() {
        throw new RuntimeException(FORBIDDEN_INSTANCE_GENERATION_EXCEPTION);
    }

    public static int countMatchingResult(
            Rewards rewards,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        return Long.valueOf(lottoTickets.getLottoTickets().stream()
                .filter(lottoTicket -> matchesByMatchedNumber(rewards, lottoTicket, winningLottoTicket, bonusNumber))
                .count()).intValue();
    }

    private static boolean matchesByMatchedNumber(
            Rewards rewards,
            LottoTicket lottoTicket,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        List<Integer> listedTicket = lottoTicket.getLottoNumbers();
        List<Integer> listedWinningTicket = winningLottoTicket.getLottoNumbers();

        boolean ticketContainsBonus = bonusNumber.isContainedIn(listedTicket);
        if (rewards.isBonus() && !ticketContainsBonus) {
            return false;
        }

        listedTicket.retainAll(listedWinningTicket);
        return rewards.hasSameMatchedNumber(listedTicket.size());
    }
}
