package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.LottoPrinter;

import java.util.List;
import java.util.Set;

public class Main {

    public static final int PRICE = 1000;

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        LottoTickets lottoTickets = new LottoTickets();
        InputView inputView = new InputView();

        purchaseLotto(lottoTickets, inputView);
        printPurchasedTickets(lottoTickets.getTickets());

        Set<Integer> winnerNumber = inputView.getWinnerNumbersFromScanner("당첨 번호를 입력해주세요: ");
        int bonusBall = getBonusBall(inputView, winnerNumber);

        LottoPrinter printer = new LottoPrinter();
        printer.printLottoResult(lottoTickets, winnerNumber, bonusBall);
    }

    private static void purchaseLotto(LottoTickets lottoTickets, InputView inputView) {
        int moneyToBuy = inputView.getPositiveIntFromScanner("구입 금액을 입력해주세요: ");
        int manualBuyCount = inputView.getPositiveIntFromScanner("수동으로 구매할 로또 수를 입력해주세요: ");
        if (moneyToBuy < PRICE || moneyToBuy < manualBuyCount * PRICE) {
            throw new RuntimeException("돈이 부족합니다!");
        }
        int autoBuyCount = (moneyToBuy - manualBuyCount * PRICE) / PRICE;

        lottoTickets.addRandomLottoTickets(autoBuyCount);
        System.out.println("수동으로 구매할 번호를 입력해주세요:");
        lottoTickets.addManualLottoTickets(manualBuyCount, inputView);
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%n", manualBuyCount, autoBuyCount);
    }

    private static void printPurchasedTickets(List<LottoTicket> purchasedTickets) {
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
