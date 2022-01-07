package step3;

import step3.input.InputResourceManager;
import step3.input.CommandLineInputView;
import step3.lotto.LottoStore;
import step3.lotto.domain.LottoTicket;
import step3.lotto.domain.WinningLotto;
import step3.output.CommandLineOutputView;
import step3.output.OutputView;
import step3.input.InputView;
import step3.output.ResultChecker;

import java.util.List;
import java.util.Map;

public class LottoMain {
    private static InputView inputView = new CommandLineInputView();
    private static OutputView outputView = new CommandLineOutputView();

    public static void main(String[] args) {
        int  amount = inputView.inputBuyTicketAmount();

        List<LottoTicket> lottoTickets = buyTickets(amount);
        outputView.printTickets(lottoTickets);

        WinningLotto winningLotto = createWinningLotto();
        checkAndShowResult(amount, lottoTickets, winningLotto);

        InputResourceManager.close();
    }

    private static void checkAndShowResult(int amount, List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        //winning 생성
        lottoTickets.stream().forEach(ticket -> winningLotto.compareAndSetResult(ticket));
        Map<Integer, Integer> results = ResultChecker.getResults(lottoTickets);

        //티켓 가져오기
        int purchaseFee = amount * 1000;
        double profitRate = ResultChecker.calculateProfitRate(purchaseFee, results);

        //매치 해보기

        //결과 반환
        outputView.printResult(results, profitRate);
    }

    private static List<LottoTicket> buyTickets(int amount) {
        return LottoStore.buy(amount);
    }

    private static WinningLotto createWinningLotto() {
        List<Integer> targetNums = inputView.inputWinningNum();
        int bonusNum = inputView.inputBonusNum(targetNums);
        return new WinningLotto(targetNums, bonusNum);
    }
}
