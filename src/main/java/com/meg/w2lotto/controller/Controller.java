package com.meg.w2lotto.controller;

import com.meg.w2lotto.constants.LottoConstant;
import com.meg.w2lotto.domain.lotto.LottoPack;
import com.meg.w2lotto.domain.result.Statistic;
import com.meg.w2lotto.service.PurchaseService;
import com.meg.w2lotto.service.ResultService;
import com.meg.w2lotto.view.InputView;
import com.meg.w2lotto.view.OutputView;

import java.util.List;

public class Controller {

    private final PurchaseService purchaseService = PurchaseService.getInstance();
    private final ResultService resultService = ResultService.getInstance();

    public void start() {

        int purchaseMoney = InputView.askPurchaseMoney();
        int purchaseCount = purchaseMoney / LottoConstant.LOTTO_COST;
        LottoPack lottoPack = purchaseService.createLottoPack(purchaseCount);

        purchaseLotto(lottoPack, purchaseCount);
        showResult(lottoPack, purchaseMoney);

    }

    private void purchaseLotto(LottoPack lottoPack, int purchaseCount) {
        int manualLottoCount = InputView.askPurchaseManualLottoCount();
        int autoLottoCount = purchaseCount - manualLottoCount;
        purchaseManualLotto(lottoPack, manualLottoCount);
        purchaseAutolLotto(lottoPack, autoLottoCount);
        OutputView.printPurchaseMessage(purchaseCount);
    }

    private void purchaseManualLotto(LottoPack lottoPack, int manualLottoCount) {
        for (int i=0; i<manualLottoCount; i++) {
            purchaseService.purchaseManualLotto(lottoPack, InputView.askPurchaseManualLottoNumbers());
        }
    }

    private void purchaseAutolLotto(LottoPack lottoPack, int autoLottoCount) {
        for (int i=0; i<autoLottoCount; i++) {
            OutputView.printLottoNumber(purchaseService.purchaseAutoLotto(lottoPack));
        }
    }

    private void showResult(LottoPack lottoPack, int purchaseMoney) {
        List<Integer> winningLottoNumbers = InputView.askLastWinningLotto();
        int bonusBall = InputView.askBonusBallNumber();
        Statistic statistic = resultService.createStatistic(winningLottoNumbers, bonusBall, lottoPack, purchaseMoney);
        OutputView.printResult(statistic.getCorrectCounts());
        OutputView.printRateOfReturn(statistic.getTotalReturn());
    }
}
