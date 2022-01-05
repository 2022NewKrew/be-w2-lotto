package be.w2.lotto.domain.winningresult;

import be.w2.lotto.domain.lottonumber.BonusNumber;
import be.w2.lotto.domain.lottoticket.LottoTicket;
import be.w2.lotto.domain.lottoticket.LottoTickets;
import be.w2.lotto.domain.lottoticket.WinningLottoTicket;

import java.math.BigInteger;
import java.util.List;

public class WinningResult {
    private final int matchedNumber;
    private final int reward;
    private final boolean isBonusRound;
    private final int count;

    private WinningResult(Reward reward, int count) {
        this.matchedNumber = reward.getMatchedNumber();
        this.reward = reward.getReward();
        this.isBonusRound = reward.isBonus();
        this.count = count;
    }

    public static WinningResult valueOf(
            Reward reward,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        int count = countMatchingResult(reward, lottoTickets, winningLottoTicket, bonusNumber);
        return new WinningResult(reward, count);
    }

    public BigInteger calculateProfit() {
        BigInteger reward = BigInteger.valueOf(this.reward);
        BigInteger count = BigInteger.valueOf(this.count);
        return reward.multiply(count);
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getReward() {
        return reward;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusRound() {
        return isBonusRound;
    }

    private static int countMatchingResult(
            Reward reward,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        return Long.valueOf(lottoTickets.getLottoTickets().stream()
                .filter(lottoTicket -> matchesByMatchedNumber(reward, lottoTicket, winningLottoTicket, bonusNumber))
                .count()).intValue();
    }

    private static boolean matchesByMatchedNumber(
            Reward reward,
            LottoTicket lottoTicket,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        List<Integer> listedTicket = lottoTicket.getLottoNumbers();
        List<Integer> listedWinningTicket = winningLottoTicket.getLottoNumbers();

        boolean ticketContainsBonus = bonusNumber.isContainedIn(listedTicket);
        if (reward.isBonus() && !ticketContainsBonus) {
            return false;
        }

        listedTicket.retainAll(listedWinningTicket);
        return reward.hasSameMatchedNumber(listedTicket.size());
    }
}
