package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        view.printLottos(tickets);
        view.showWinningNumbersPrompt(context);
    }

    public void onWinningNumbersInput(LottoContext context, List<Integer> winningNumbers) {
        Map<LottoResult, Integer> results = counter.getResults(context.getTickets(), winningNumbers);
        float profit = calculator.calculate(context.getPayment(), results);
        List<Map.Entry<LottoResult, Integer>> ordered = orderResults(results);
        view.printResults(ordered, ((int) (profit * 100)));
    }

    private List<Map.Entry<LottoResult, Integer>> orderResults(Map<LottoResult, Integer> results) {
        return LottoResult.orderWinsByRankAsc()
                .stream()
                .map(x -> new AbstractMap.SimpleEntry<>(x, results.get(x)))
                .collect(Collectors.toList());
    }
}
