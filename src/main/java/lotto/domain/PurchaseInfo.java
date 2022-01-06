package lotto.domain;

public class PurchaseInfo {
    private final long numOfManualLottos;
    private final long numOfAutoLottos;

    public PurchaseInfo(long numOfManualLottos, long numOfAutoLottos) {
        this.numOfManualLottos = numOfManualLottos;
        this.numOfAutoLottos = numOfAutoLottos;
    }

    public long getNumOfAutoLottos() {
        return numOfAutoLottos;
    }

    public long getNumOfManualLottos() {
        return numOfManualLottos;
    }
}
