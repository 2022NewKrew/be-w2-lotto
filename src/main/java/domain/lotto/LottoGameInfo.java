package domain.lotto;

import static domain.lotto.LottoValidator.*;
import static util.LottoConst.LOTTO_PRICE;

public class LottoGameInfo {

    private final int lottoQuantity;
    private final int autoLottoQuantity;

    public LottoGameInfo(int inputMoney, int manualLottoQuantity) {
        validatePositiveNumber(inputMoney);
        validateInputMoney(inputMoney);
        validateNumOfPurchaseManually(inputMoney, manualLottoQuantity);
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
        this.autoLottoQuantity = this.lottoQuantity - manualLottoQuantity;
    }

    public int getPurchaseQuantity() {
        return lottoQuantity;
    }

    public int getAutomaticallyPurchaseQuantity() {
        return autoLottoQuantity;
    }
}
