package lotto.view;

import lotto.domain.*;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

public class LottoShop {

    public void buy() {
        InputUtil inputUtil = new InputUtil();

        LottoPurchaseInfo purchaseInfo = new LottoPurchaseInfo(inputUtil.inputPrice());
        LottoCollection lottoCollection = new LottoCollection(purchaseInfo.getCountOfPurchaseLotto());
        OutputUtil.printLottoCollection(lottoCollection);

        WinningLotto winningLotto = new WinningLotto(inputUtil.inputWinningNumbers());
        RankCollection rankCollection = RankCollection.of(lottoCollection, winningLotto);

        LottoStatistics lottoStatistics = LottoStatistics.of(rankCollection, purchaseInfo);
        OutputUtil.printStatistics(lottoStatistics);

    };
}
