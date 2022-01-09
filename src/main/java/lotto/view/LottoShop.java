package lotto.view;

import lotto.domain.LottoCollection;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.WinningLotto;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

import java.util.List;

public class LottoShop {

    public void buy() {
        InputUtil inputUtil = new InputUtil();

        LottoPurchaseInfo purchaseInfo = new LottoPurchaseInfo(inputUtil.inputPrice());
        LottoCollection lottoCollection = new LottoCollection(purchaseInfo.getCountOfPurchaseLotto());
        OutputUtil.printLottoCollection(lottoCollection);

        WinningLotto winningLotto = new WinningLotto(inputUtil.inputWinningNumbers());




    };
}
