package com.cold.controller;

import com.cold.domain.GameLogic;
import com.cold.domain.SingleTicket;
import com.cold.domain.WinningLotto;
import com.cold.domain.WholeTickets;
import com.cold.view.InputView;
import com.cold.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void playLotto() {

        int purchaseMoney = InputView.inputPurchaseMoney();
        int manualLottoCount = InputView.inputManualPurchaseCount();
        int autoLottoCount = GameLogic.calculateAutoLottoCount(purchaseMoney, manualLottoCount);

        WholeTickets wholeTickets = new WholeTickets(autoLottoCount);

        if (manualLottoCount > 0) {
            List<SingleTicket> manualLotto = InputView.inputManualLottoNumbers(manualLottoCount);
            wholeTickets.addManualLotto(manualLotto);
        }

        OutputView.printPurchaseResult(wholeTickets, autoLottoCount, manualLottoCount);

        List<Integer> lastWinningNums = InputView.inputLastWinningNums();
        int bonusBall = InputView.inputBonusBall();

        WinningLotto winningLotto = new WinningLotto(lastWinningNums, bonusBall);

        wholeTickets.calculateResult(winningLotto);
        double profitRate = GameLogic.calculateProfitRate(wholeTickets);
        wholeTickets.setProfitRate(profitRate);

        OutputView.printGameResult(wholeTickets);
    }
}
