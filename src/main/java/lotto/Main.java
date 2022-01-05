package lotto;

import lotto.domain.Gambler;
import lotto.domain.LottoShop;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.LottoPrinter;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.LottoShop.PRICE;

public class Main {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        InputView inputView = new InputView();

        int moneyToBuy = inputView.getPositiveIntFromScanner("구입 금액을 입력해주세요: ");
        int manualBuyCount = inputView.getPositiveIntFromScanner("수동으로 구매할 로또 수를 입력해주세요: ");
        int autoBuyCount = (moneyToBuy - manualBuyCount * PRICE) / PRICE;
        List<LottoTicket> allTickets = purchaseLottoTickets(lottoShop, inputView, manualBuyCount, autoBuyCount);

        Gambler gambler = new Gambler(allTickets);
        printPurchasedTickets(allTickets);

        Set<Integer> winnerNumber = inputView.getWinnerNumbersFromScanner("당첨 번호를 입력해주세요: ");
        lottoShop.setWinnerNumber(winnerNumber);
        int bonusBall = getBonusBall(inputView, winnerNumber);

        LottoPrinter printer = new LottoPrinter();
        printer.printLottoResult(lottoShop, gambler, bonusBall);
    }

    private static List<LottoTicket> purchaseLottoTickets(LottoShop lottoShop, InputView inputView, int manualBuyCount, int autoBuyCount) {
        List<LottoTicket> manualTickets = purchaseManualLotto(lottoShop, inputView, manualBuyCount);
        List<LottoTicket> autoTickets = purchaseAutoLotto(lottoShop, autoBuyCount);
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%n", manualTickets.size(), autoTickets.size());
        return Stream.of(autoTickets, manualTickets)
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List<LottoTicket> purchaseAutoLotto(LottoShop lottoShop, int numOfPurchase) {
        return lottoShop.sellAutoLottoTicket(numOfPurchase);
    }

    private static List<LottoTicket> purchaseManualLotto(LottoShop lottoShop, InputView inputView, int numOfPurchase) {
        System.out.println("수동으로 구매할 번호를 입력해주세요:");
        List<Set<Integer>> pickedNumbers = IntStream.range(0, numOfPurchase)
                .mapToObj(i -> inputView.getWinnerNumbersFromScanner())
                .collect(Collectors.toList());
        return lottoShop.sellManualLottoTicket(pickedNumbers);
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
