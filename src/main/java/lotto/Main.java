package lotto;

import lotto.domain.Gambler;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.LottoPrinter;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        InputView inputView = new InputView();
        Gambler gambler = new Gambler();

        int moneyToBuy = inputView.getPositiveIntFromScanner("구입 금액을 입력해주세요: ");
        lottoShop.sellLottoTicket(gambler, moneyToBuy);

        List<LottoTicket> purchasedTickets = gambler.getTickets();
        System.out.printf("로또 %d장을 구매했습니다.%n", purchasedTickets.size());
        System.out.println(purchasedTickets);

        Set<Integer> winnerNumber = inputView.getWinnerNumbersFromScanner("당첨 번호를 입력해주세요: ");
        lottoShop.setWinnerNumber(winnerNumber);

        LottoPrinter printer = new LottoPrinter();
        printer.PrintLottoMatchingResult(lottoShop, gambler);
    }
}
