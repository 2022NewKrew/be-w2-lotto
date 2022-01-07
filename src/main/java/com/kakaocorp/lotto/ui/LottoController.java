package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.*;

public class LottoController {

    private final LottoView view;
    private final LottoDispenser dispenser;
    private final ResultCounter counter;
    private final ProfitCalculator calculator;

    public LottoController(LottoView view, Random random) {
        this.view = view;
        this.dispenser = new LottoDispenser(random);
        this.counter = new ResultCounter();
        this.calculator = new ProfitCalculator();
    }

    public void onStart() {
        int payment = view.showPaymentPrompt();
        List<LottoTicket> tickets = handleTicketsPart(payment);
        handleProfitPart(payment, tickets);
    }

    private List<LottoTicket> handleTicketsPart(int payment) {
        int manualCount = view.showManualCountPrompt();
        view.showManualTicketPromptHeader();
        List<LottoTicket> manual = showManualTicketsPrompts(manualCount);
        List<LottoTicket> tickets = dispenser.purchase(payment, manual);
        printTickets(tickets);
        return tickets;
    }

    private void handleProfitPart(int payment, List<LottoTicket> tickets) {
        List<Integer> winningNumbers = view.showWinningNumbersPrompt();
        int bonusNumber = view.showBonusNumberPrompt();
        view.printResultHeader();
        LottoRecord record = new LottoRecord(Set.copyOf(winningNumbers), bonusNumber);
        float profit = computeProfit(payment, tickets, record);
        view.printProfit((int) (100 * profit));
    }

    private List<LottoTicket> showManualTicketsPrompts(int manualCount) {
        List<LottoTicket> manualTickets = new ArrayList<>(manualCount);
        for (int i = 0; i < manualCount; i++) {
            List<Integer> numbers = view.acceptManualTicketInput();
            LottoTicket ticket = new LottoTicket(Set.copyOf(numbers));
            manualTickets.add(ticket);
        }
        return manualTickets;
    }

    private void printTickets(Collection<LottoTicket> tickets) {
        view.printTicketHeader(tickets.size());
        for (LottoTicket ticket : tickets) {
            view.printTicket(ticket);
        }
    }

    private float computeProfit(int payment, List<LottoTicket> tickets, LottoRecord record) {
        for (LottoTicket ticket : tickets) {
            counter.count(ticket, record);
        }
        counter.forEachOrdered(LottoResult.VALUE_COMPARATOR_ASC, this::printResult);
        int gain = counter.getTotalGain();
        return calculator.calculate(payment, gain);
    }

    private void printResult(LottoResult result, int count) {
        if (result == LottoResult.LOSE) {
            return;
        }
        boolean hasBonus = result.hasBonus();
        int matches = result.getMatches();
        int value = result.getValue();
        if (hasBonus) {
            view.printBonusResult(matches, value, count);
            return;
        }
        view.printNormalResult(matches, value, count);
    }
}
