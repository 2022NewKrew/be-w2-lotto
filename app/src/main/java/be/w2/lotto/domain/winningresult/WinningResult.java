package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

public class WinningResult {
    private final Rewards rewards;
    private final int count;

    private WinningResult(Rewards rewards, int count) {
        this.rewards = rewards;
        this.count = count;
    }

    public static WinningResult valueOf(
            Rewards rewards,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        int count = WinningMatching.countMatchingResult(rewards, lottoTickets, winningLottoTicket, bonusNumber);
        return new WinningResult(rewards, count);
    }

    public int getMatchedNumber() {
        return rewards.getMatchedNumber();
    }

    public int getReward() {
        return rewards.getReward();
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusRound() {
        return rewards.isBonus();
    }
}
