package lotto.domain.game;

import java.util.Arrays;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 15_000_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank valueOf(WinningLotto winningLotto, Lotto lottoTicket) {
        int matchCount = winningLotto.ticketMatchCount(lottoTicket);

        LottoRank rank = Arrays.stream(values())
            .filter(lottoRank -> lottoRank.matchCount == matchCount)
            .findFirst()
            .orElseGet(() -> NONE);

        if (rank == SECOND && !winningLotto.isTicketHasBonusNumber(lottoTicket)) {
            return THIRD;
        }
        return rank;
    }

    public long calculatePrizeMoneyWithCount(long count) {
        return prizeMoney * count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
