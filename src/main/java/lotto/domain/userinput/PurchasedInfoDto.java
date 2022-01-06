package lotto.domain.userinput;

import lotto.domain.Lotto;
import lotto.domain.util.PurchasedInfoValidator;

import java.util.List;

public class PurchasedInfoDto {
    private static final PurchasedInfoValidator VALIDATOR = new PurchasedInfoValidator();

    private final int purchasePrice;
    private final int countOfManualLotto;
    private final List<Lotto> manualLottoBundle;

    public PurchasedInfoDto(int purchasePrice, int countOfManualLotto, List<Lotto> manualLottoBundle) {
        this.purchasePrice = purchasePrice;
        this.countOfManualLotto = countOfManualLotto;
        this.manualLottoBundle = manualLottoBundle;
        VALIDATOR.validatePurchasedInfoInput(purchasePrice, countOfManualLotto);
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