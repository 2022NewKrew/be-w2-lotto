package lotto.domain;

import static lotto.LottoSimulator.LOTTO_PRICE;

public class PurchaseInfo {
    private final long numOfManualLottos;
    private final long numOfAutoLottos;

    public PurchaseInfo(long purchaseAmount, long numOfManualLottos) {
        this.numOfManualLottos = numOfManualLottos;
        this.numOfAutoLottos = purchaseAmount / LOTTO_PRICE - numOfManualLottos;
    }

    public long getNumOfAutoLottos() {
        return numOfAutoLottos;
    }

    public long getNumOfManualLottos() {
        return numOfManualLottos;
    }
}
