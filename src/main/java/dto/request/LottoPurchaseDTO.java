package dto.request;

import java.util.List;

public class LottoPurchaseDTO {
    private final Integer bugdet;
    private final Integer numberOfManualLotto;
    private final List<List<Integer>> manualLottoTickets;

    public LottoPurchaseDTO(Integer bugdet, Integer numberOfManualLotto, List<List<Integer>> manualLottoTickets) {
        this.bugdet = bugdet;
        this.numberOfManualLotto = numberOfManualLotto;
        this.manualLottoTickets = manualLottoTickets;
    }

    public Integer getBudget() {
        return this.bugdet;
    }

    public Integer getNumberOfManualLotto() {
        return this.numberOfManualLotto;
    }

    public List<List<Integer>> getManualLottoTickets() {
        return this.manualLottoTickets;
    }
}
