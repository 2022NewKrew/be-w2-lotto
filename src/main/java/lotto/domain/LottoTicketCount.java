package lotto.domain;

public class LottoTicketCount {

    private final int count;

    public LottoTicketCount(int count) {
        if (isNegative(count)) {
            throw new IllegalArgumentException("구매할 로또 수는 0개 이상이어야 합니다.");
        }
        this.count = count;
    }

    public LottoTicketCount sub(LottoTicketCount lottoTicketCount) {
        int remainingCount = this.count - lottoTicketCount.count;
        return new LottoTicketCount(remainingCount);
    }

    private boolean isNegative(int count) {
        return count < 0;
    }

    public int getCount() {
        return count;
    }
}
