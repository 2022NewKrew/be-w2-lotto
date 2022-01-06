package domain.lotto;

import static domain.lotto.LottoValidator.*;
import static util.LottoConst.LOTTO_PRICE;

public class LottoGameInfo {

    private final int inputMoney;
    private final int lottoQuantity;
    private final int manualLottoQuantity;
    private final int autoLottoQuantity;

    public LottoGameInfo(int inputMoney) {
        validatePositiveNumber(inputMoney);
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
        this.manualLottoQuantity = 0;
        this.autoLottoQuantity = this.lottoQuantity - manualLottoQuantity;
    }

    public LottoGameInfo(int inputMoney, int manualLottoQuantity) {
        validatePositiveNumber(inputMoney);
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.lottoQuantity = inputMoney / LOTTO_PRICE;
        this.manualLottoQuantity = manualLottoQuantity;
        validateNumOfPurchaseManually(this.inputMoney, this.manualLottoQuantity);
        this.autoLottoQuantity = this.lottoQuantity - manualLottoQuantity;
    }

    public int getPurchaseQuantity() {
        return lottoQuantity;
    }

    public int getAutomaticallyPurchaseQuantity() {
        return autoLottoQuantity;
    }

}
