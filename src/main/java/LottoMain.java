import input.InputResourceManager;
import input.CommandLineInputView;
import lotto.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import output.CommandLineOutputView;
import output.OutputView;
import input.InputView;
import output.ResultChecker;

import java.util.List;
import java.util.Map;

public class LottoMain {
    private static InputView inputView = new CommandLineInputView();
    private static OutputView outputView = new CommandLineOutputView();

    public static void main(String[] args) {
        int  amount = inputView.inputBuyTicketAmount();

        List<LottoTicket> lottoTickets = buyTickets(amount);
        printTickets(lottoTickets);

        WinningLotto winningLotto = createWinningLotto();
        checkAndShowResult(amount, lottoTickets, winningLotto);

        InputResourceManager.close();
    }

    private static void checkAndShowResult(int amount, List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        lottoTickets.stream().forEach(ticket -> winningLotto.compareAndSetResult(ticket));
        Map<Integer, Integer> results = ResultChecker.getResults(lottoTickets, winningLotto);

        int purchaseFee = amount * 1000;
        double profitRate = ResultChecker.calculateProfitRate(purchaseFee, results);

        outputView.printResult(results, profitRate);
    }

    private static void printTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream().forEach(System.out::println);
    }

    private static List<LottoTicket> buyTickets(int amount) {
        return LottoStore.buy(amount);
    }

    private static WinningLotto createWinningLotto() {
        System.out.println("지난주 당첨 번호를 입력해주세요. 입력 예시 : 1,2,3,4,5,6");
        List<Integer> targetNums = inputView.inputLottoNum();
        int bonusNum = inputView.inputBonusNum(targetNums);
        return new WinningLotto(targetNums, bonusNum);
    }
}
