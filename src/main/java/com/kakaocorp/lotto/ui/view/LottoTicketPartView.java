package com.kakaocorp.lotto.ui.view;

import com.kakaocorp.lotto.model.LottoTicket;

import java.util.List;

public interface LottoTicketPartView extends BaseLottoView {

    int showManualCountPrompt();
    void showManualTicketPromptHeader();
    List<Integer> acceptManualTicketInput();
    void printTicketHeader(int size);
    void printTicket(LottoTicket ticket);
}
