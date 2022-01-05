package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.model.LottoResult;
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
    void printResult(LottoResult result, int count);
    void printProfit(int profit);
}
