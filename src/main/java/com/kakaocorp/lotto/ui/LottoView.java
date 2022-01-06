package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoTicket;

import java.util.List;

public interface LottoView {

    int showPaymentPrompt();
    int showManualCountPrompt();
    void showManualTicketPromptHeader();
    List<Integer> acceptManualTicketInput();
    void printTicketHeader(int size);
    void printTicket(LottoTicket ticket);
    List<Integer> showWinningNumbersPrompt();
    int showBonusNumberPrompt();
    void printResultHeader();
    void printNormalResult(int matches, int value, int count);
    void printBonusResult(int matches, int value, int count);
    void printProfit(int profit);
}
