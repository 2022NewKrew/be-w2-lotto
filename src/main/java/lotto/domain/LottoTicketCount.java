package lotto.domain;

public class LottoTicketCount {
    private final int manualTicketCount;
    private final int autoTicketCount;


    public LottoTicketCount(int totalTicketCount, int manualTicketCount) {
        if (isNegative(totalTicketCount) || isNegative(manualTicketCount)) {
            throw new IllegalArgumentException("구매할 로또 수는 0개 이상이어야 합니다.");
        }
        if (totalTicketCount < manualTicketCount) {
            throw new IllegalArgumentException("구매할 수 있는 로또 수를 초과했습니다.");
        }
        this.manualTicketCount = manualTicketCount;
        this.autoTicketCount = totalTicketCount - manualTicketCount;
    }

    private boolean isNegative(int count) {
        return count < 0;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }
}
