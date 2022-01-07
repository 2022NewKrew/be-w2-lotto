package com.kakaocorp.lotto.ui.view;

import java.util.List;

public interface LottoProfitPartView extends BaseLottoView {

    List<Integer> showWinningNumbersPrompt();
    int showBonusNumberPrompt();
    void printResultHeader();
    void printNormalResult(int matches, int value, int count);
    void printBonusResult(int matches, int value, int count);
    void printProfit(int profit);
}
