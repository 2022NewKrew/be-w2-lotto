package step4.command;

import step4.input.InputView;
import step4.lotto.LottoStore;
import step4.lotto.domain.LottoTicket;
import step4.lotto.domain.WinningLotto;
import step4.output.OutputView;
import step4.output.ResultChecker;

import java.util.List;
import java.util.Map;

public class LottoCommander {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoCommander(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int inputPayAmount() {
        return inputView.inputBuyTicketAmount();
    }

    public void printTicketInfo(List<LottoTicket> lottoTickets) {
        outputView.printTickets(lottoTickets);
    }

    public void checkAndShowResult(int amount, List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        lottoTickets.stream().forEach(ticket -> winningLotto.compareAndSetResult(ticket));
        Map<Integer, Integer> results = ResultChecker.getResults(lottoTickets);

        int purchaseFee = amount * 1000;
        double profitRate = ResultChecker.calculateProfitRate(purchaseFee, results);

        outputView.printResult(results, profitRate);
    }

    public List<LottoTicket> buyTickets(int amount) {
        return LottoStore.buy(amount);
    }

    public WinningLotto createWinningLotto() {
        List<Integer> targetNums = inputView.inputWinningNum();
        int bonusNum = inputView.inputBonusNum(targetNums);
        return new WinningLotto(targetNums, bonusNum);
    }
}
