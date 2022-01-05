package lotto.domain.userinput;

import lotto.domain.Lotto;
import lotto.domain.util.LottoValidator;

import java.util.List;

public class PurchasedLottoInput {
    private static final LottoValidator VALIDATOR = new LottoValidator();

    private final int purchasePrice;
    private final int countOfManualLotto;
    private final List<Lotto> manualLottoBundle;

    public PurchasedLottoInput(int purchasePrice, int countOfManualLotto, List<Lotto> manualLottoBundle) {
        this.purchasePrice = purchasePrice;
        this.countOfManualLotto = countOfManualLotto;
        this.manualLottoBundle = manualLottoBundle;
        VALIDATOR.validatePurchasedLottoInput(purchasePrice, countOfManualLotto);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getCountOfManualLotto() {
        return countOfManualLotto;
    }

    public List<Lotto> getManualLottoBundle() {
        return manualLottoBundle;
    }
}