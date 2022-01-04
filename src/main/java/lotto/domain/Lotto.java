package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoTicket;

    public Lotto(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoMatchResult countMatchedNumber(WinningLotto winningLotto) {
        int matchCount = (int) winningLotto.getNumbers().stream()
                .filter(lottoTicket::contains).count();
        boolean isBonusBallMatched = lottoTicket.contains(winningLotto.getBonusBall());
        return new LottoMatchResult(matchCount, isBonusBallMatched);
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}