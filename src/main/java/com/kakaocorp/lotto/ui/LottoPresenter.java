package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoPresenter {

    private final LottoView view;
    private final LottoDispenser dispenser;
    private final ResultCounter counter;
    private final ProfitCalculator calculator;

    public LottoPresenter(LottoView view, LottoDispenser dispenser, ResultCounter counter, ProfitCalculator calculator) {
        this.view = view;
        this.dispenser = dispenser;
        this.counter = counter;
        this.calculator = calculator;
    }

    public void onStart() {
        int payment = view.showPaymentPrompt();
        int manualCount = view.showManualCountPrompt();
        List<LottoTicket> tickets = generateTickets(payment, manualCount);
        printTickets(tickets);

        List<Integer> winningNumbers = view.showWinningNumbersPrompt();
        int bonusNumber = view.showBonusNumberPrompt();

        LottoRecord record = new LottoRecord(Set.copyOf(winningNumbers), bonusNumber);
        checkResult(payment, tickets, record);
    }

    private List<LottoTicket> generateTickets(int payment, int manualCount) {
        List<LottoTicket> manualTickets = new ArrayList<>(manualCount);
        view.showManualTicketPromptHeader();
        for (int i = 0; i < manualCount; i++) {
            List<Integer> numbers = view.acceptManualTicketInput();
            LottoTicket ticket = new LottoTicket(Set.copyOf(numbers));
            manualTickets.add(ticket);
        }
        return dispenser.purchase(payment, manualTickets);
    }

    private void printTickets(Collection<LottoTicket> tickets) {
        view.printTicketHeader(tickets.size());
        for (LottoTicket ticket : tickets) {
            view.printTicket(ticket);
        }
    }

    private void checkResult(int payment, List<LottoTicket> tickets, LottoRecord record) {
        for (LottoTicket ticket : tickets) {
            counter.count(ticket, record);
        }
        view.printResultHeader();
        counter.forEachOrdered(LottoResult.VALUE_COMPARATOR_ASC, this::printResult);
        int gain = counter.getTotalGain();
        float profit = calculator.calculate(payment, gain);
        view.printProfit((int) (100 * profit));
    }

    private void printResult(LottoResult result, int count) {
        if (result == LottoResult.LOSE) {
            return;
        }
        view.printResult(result, count);
    }
}
