package view.dto;

import java.util.List;

public class LottoPurchaseRequest {

    private final int amount;

    private final int manualLottoCount;

    private final List<List<Integer>> manualLottoTickets;

    public LottoPurchaseRequest(int amount, int manualLottoCount, List<List<Integer>> manualLottoTickets) {
        this.amount = amount;
        this.manualLottoCount = manualLottoCount;
        this.manualLottoTickets = manualLottoTickets;
    }

    public int getAmount() {
        return amount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public List<List<Integer>> getManualLottoTickets() {
        return manualLottoTickets;
    }
}
