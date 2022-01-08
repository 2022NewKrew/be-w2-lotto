package lotto.view;

import lotto.domain.LottoCollection;
import lotto.domain.LottoPurchaseInfo;
import lotto.util.InputUtil;

public class LottoShop {

    public void buy() {
        InputUtil inputUtil = new InputUtil();

        int price = inputUtil.inputPrice();
        LottoPurchaseInfo purchaseInfo = new LottoPurchaseInfo(price);
        LottoCollection lottoCollection = new LottoCollection(purchaseInfo.getCountOfPurchaseLotto());



    };
}
