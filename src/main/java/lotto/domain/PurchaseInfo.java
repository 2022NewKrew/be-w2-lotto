package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.LottoSimulator.LOTTO_PRICE;

public class PurchaseInfo {
    private final long numOfManualLottos;
    private final long numOfAutoLottos;
    private final List<String> manualLottoList;

    public PurchaseInfo(long purchaseAmount, long numOfManualLottos, List<String> manualLottoList) {
        this.numOfManualLottos = numOfManualLottos;
        this.numOfAutoLottos = purchaseAmount / LOTTO_PRICE - numOfManualLottos;
        this.manualLottoList = manualLottoList;
    }

    public long getNumOfAutoLottos() {
        return numOfAutoLottos;
    }

    public long getNumOfManualLottos() {
        return numOfManualLottos;
    }

    public List<String> getManualLottoList() {
        return Collections.unmodifiableList(manualLottoList);
    }
}
