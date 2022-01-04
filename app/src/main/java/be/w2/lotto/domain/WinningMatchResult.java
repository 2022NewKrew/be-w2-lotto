package be.w2.lotto.domain;

import java.math.BigInteger;
import java.util.List;

public class WinningMatchResult {
    private final int matchedNumber;
    private final int reward;
    private final boolean isBonusRound;
    private final int count;

    private WinningMatchResult(RewardRule rewardRule, int count) {
        this.matchedNumber = rewardRule.getMatchedNumber();
        this.reward = rewardRule.getReward();
        this.isBonusRound = rewardRule.isBonus();
        this.count = count;
    }

    public static WinningMatchResult valueOf(
            RewardRule rewardRule,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        int count = countMatching(rewardRule, lottoTickets, winningLottoTicket, bonusNumber);
        return new WinningMatchResult(rewardRule, count);
    }

    public BigInteger calculateProfit() {
        return BigInteger.valueOf(reward).multiply(BigInteger.valueOf(count));
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

    private static int countMatching(
            RewardRule rewardRule,
            LottoTickets lottoTickets,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        return (int) lottoTickets.getLottoTickets().stream()
                .filter(lottoTicket -> matchesByMatchedNumber(rewardRule, lottoTicket, winningLottoTicket, bonusNumber))
                .count();
    }

    private static boolean matchesByMatchedNumber(
            RewardRule matchedNumber,
            LottoTicket lottoTicket,
            WinningLottoTicket winningLottoTicket,
            BonusNumber bonusNumber
    ) {
        List<Integer> listedTicket = lottoTicket.getLottoNumbers();
        List<Integer> listedWinningTicket = winningLottoTicket.getLottoNumbers();

        boolean ticketContainsBonus = bonusNumber.isContainedIn(listedTicket);
        listedTicket.retainAll(listedWinningTicket);

        if (matchedNumber.isBonus() && !ticketContainsBonus) {
            return false;
        }

        return matchedNumber.hasSameMatchedNumber(listedTicket.size());
    }
}
