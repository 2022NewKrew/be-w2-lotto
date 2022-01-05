package step2.domain;

import step2.domain.service.LottoSheetIssuer;
import step3.util.Validator;

public class LottoConfig {

    // 구매 금액
    private Integer purchaseAmount;

    public LottoConfig(Integer purchaseAmount) {
        this.purchaseAmount = Validator.GRATER_THAN_1000(purchaseAmount);
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getNumberOfLotto(){
        return purchaseAmount / LottoSheetIssuer.PRICE;
    }

}
