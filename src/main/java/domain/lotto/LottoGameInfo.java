package domain.lotto;

import java.util.Collections;
import java.util.List;

import static util.LottoConst.LOTTO_PRICE;

public class LottoGameInfo {

    private final int inputMoney;
    private final int lottoQuantity;
    private final int manualLottoQuantity;
    private final int autoLottoQuantity;
    private final List<Lotto> manualPurchaseLottoList;

    public LottoGameInfo(int inputMoney) {
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.manualPurchaseLottoList = Collections.emptyList();
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
        this.manualLottoQuantity = 0;
        this.autoLottoQuantity = this.lottoQuantity - manualLottoQuantity;
    }

    public LottoGameInfo(int inputMoney, List<Lotto> manualPurchaseLottoList) {
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.manualPurchaseLottoList = manualPurchaseLottoList;
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
        this.manualLottoQuantity = manualPurchaseLottoList.size();
        this.autoLottoQuantity = this.lottoQuantity - manualLottoQuantity;
    }

    private void validateInputMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("[에러] 구입 금액은 반드시 %s원 이상이어야 합니다.", LOTTO_PRICE));
        }
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public int getPurchaseQuantity() {
        return lottoQuantity;
    }

    public int getManuallyPurchaseQuantity() {
        return manualLottoQuantity;
    }

    public int getAutomaticallyPurchaseQuantity() {
        return autoLottoQuantity;
    }

    public List<Lotto> getManualPurchaseLottoList() {
        return manualPurchaseLottoList;
    }
}
