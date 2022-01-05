package domain.model;

import java.util.List;

public class PurchaseInfo {

    private final int autoLottoCount;

    private final int manualLottoCount;

    private final List<List<Integer>> manualLottoTickets;

    public PurchaseInfo(int autoLottoCount, int manualLottoCount, List<List<Integer>> manualLottoTickets) {
        this.autoLottoCount = autoLottoCount;
        this.manualLottoCount = manualLottoCount;
        this.manualLottoTickets = manualLottoTickets;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public List<List<Integer>> getManualLottoTickets() {
        return manualLottoTickets;
    }
}
