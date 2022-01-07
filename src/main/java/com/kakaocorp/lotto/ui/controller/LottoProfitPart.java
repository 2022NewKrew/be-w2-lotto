package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.LottoRecord;
import com.kakaocorp.lotto.model.LottoResult;
import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.LottoProfitPartView;

import java.util.List;
import java.util.Set;

public class LottoProfitPart extends LottoControllerPart<LottoProfitPartView> {

    private final ResultCounter counter;
    private final ProfitCalculator calculator;

    public LottoProfitPart(LottoProfitPartView view, ResultCounter counter, ProfitCalculator calculator) {
        super(view);
        this.counter = counter;
        this.calculator = calculator;
    }

    public void handle(int payment, List<LottoTicket> tickets) {
        List<Integer> winningNumbers = view.showWinningNumbersPrompt();
        int bonusNumber = view.showBonusNumberPrompt();
        view.printResultHeader();
        LottoRecord record = new LottoRecord(Set.copyOf(winningNumbers), bonusNumber);
        float profit = computeProfit(payment, tickets, record);
        view.printProfit((int) (100 * profit));
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
