package dto.input;

import java.util.List;

public class PurchaseDto {
    private final int purchasePrise;
    private final List<List<Integer>> manualLottoNumberLists;

    public PurchaseDto(int purchasePrise, List<List<Integer>> manualLottoNumberLists) {
        this.purchasePrise = purchasePrise;
        this.manualLottoNumberLists = manualLottoNumberLists;
    }

    public int getPurchasePrice() {
        return purchasePrise;
    }

    public List<List<Integer>> getManualLottoNumberLists() {
        return manualLottoNumberLists;
    }
}
