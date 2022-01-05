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

        List<LottoTicket> tickets = purchaseLottoTickets(lottoShop, inputView);
        Gambler gambler = new Gambler(tickets);
        printPurchasedTickets(tickets);

        Set<Integer> winnerNumber = inputView.getWinnerNumbersFromScanner("당첨 번호를 입력해주세요: ");
        lottoShop.setWinnerNumber(winnerNumber);
        int bonusBall = getBonusBall(inputView, winnerNumber);

        LottoPrinter printer = new LottoPrinter();
        printer.printLottoResult(lottoShop, gambler, bonusBall);
    }

    private static List<LottoTicket> purchaseLottoTickets(LottoShop lottoShop, InputView inputView) {
        int moneyToBuy = inputView.getPositiveIntFromScanner("구입 금액을 입력해주세요: ");
        return lottoShop.sellLottoTicket(moneyToBuy);
    }

    private static void printPurchasedTickets(List<LottoTicket> purchasedTickets) {
        System.out.printf("로또 %d장을 구매했습니다.%n", purchasedTickets.size());
        purchasedTickets.forEach(System.out::println);
        System.out.println();
    }

    private static int getBonusBall(InputView inputView, Set<Integer> winnerNumber) {
        int bonusBall;
        do {
            bonusBall = inputView.getPositiveIntFromScanner("보너스 볼을 입력해주세요: ");
        } while (winnerNumber.contains(bonusBall));
        return bonusBall;
    }
}
