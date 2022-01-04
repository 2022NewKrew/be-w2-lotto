package com.cold.controller;

import com.cold.domain.GameLogic;
import com.cold.domain.WinningLotto;
import com.cold.domain.WholeTickets;
import com.cold.view.InputView;
import com.cold.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void playLotto() throws Exception {
        WholeTickets wholeTickets = new WholeTickets();
        GameLogic gameLogic = new GameLogic();

        int purchasedCount = InputView.purchase();

        wholeTickets.purchaseTickets(purchasedCount);

        OutputView.printPurchaseResult(wholeTickets, purchasedCount);

        List<Integer> lastWinningNums = InputView.inputLastWinningNums();
        Integer bonusBall = InputView.inputBonusBall();

        WinningLotto winningLotto = new WinningLotto(lastWinningNums, bonusBall);

        gameLogic.setResult(wholeTickets, winningLotto);
        gameLogic.setProfitRate(purchasedCount);

        OutputView.printGameResult(gameLogic);
    }
}
