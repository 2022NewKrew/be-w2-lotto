package dto;

import java.util.List;

public class PurchasingSheet {
    private final int autoLottoAmount;
    private final int manualLottoAmount;
    private final List<List<Integer>> manualLottoNumber;

    public PurchasingSheet(int autoLottoAmount, int manualLottoAmount, List<List<Integer>> manualLottoNumber) {
        this.autoLottoAmount = autoLottoAmount;
        this.manualLottoAmount = manualLottoAmount;
        this.manualLottoNumber = manualLottoNumber;
    }

    public int getAutoLottoAmount() {
        return autoLottoAmount;
    }

    public int getManualLottoAmount() {
        return manualLottoAmount;
    }

    public List<List<Integer>> getManualLottoNumber() {
        return manualLottoNumber;
    }
}
