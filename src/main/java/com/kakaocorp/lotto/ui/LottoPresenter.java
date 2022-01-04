package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

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
        view.attachPresenter(this);

        /*
          FIXME Presenter와 View에서 호출이 오가며 유지되어야 하는 맥락 정보를
           멤버 변수나 함수 인자로 나열하지 않고 객체로 전달했는데
           괜찮은 설계인가 하는 생각 - 테스트는 훨씬 용이해진 듯
         */
        LottoContext context = new LottoContext();
        view.showPaymentPrompt(context);
    }

    public void onPaymentInput(LottoContext context, int payment) {
        List<LottoTicket> tickets = dispenser.purchase(payment);
        context.setPayment(payment);
        context.setTickets(tickets);

        view.printTicketHeader(tickets.size());
        for (LottoTicket ticket : tickets) {
            view.printTicket(ticket);
        }
        view.showWinningNumbersPrompt(context);
    }

    public void onWinningNumbersInput(LottoContext context, List<Integer> winningNumbers, int bonusNumber) {
        LottoRecord record = new LottoRecord(Set.copyOf(winningNumbers), bonusNumber);
        for (LottoTicket ticket : context.getTickets()) {
            counter.count(ticket, record);
        }
        float profit = calculator.calculate(context.getPayment(), counter.getTotalGain());
        view.printResultHeader();
        counter.forEachOrdered(LottoResult.VALUE_COMPARATOR_ASC, this::printResult);
        view.printProfit(((int) (profit * 100)));
    }

    private void printResult(LottoResult result, int count) {
        if (result == LottoResult.LOSE) {
            return;
        }
        view.printResult(result, count);
    }
}
