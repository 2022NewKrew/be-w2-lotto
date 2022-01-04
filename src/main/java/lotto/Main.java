package lotto;

import lotto.domain.Gambler;
import lotto.domain.LottoShop;
import lotto.view.LottoPrinter;

public class Main {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();

        Gambler gambler = new Gambler();

        lottoShop.sellLottoTicket(gambler);
        lottoShop.setWinnerNumberFromScanner();

        LottoPrinter printer = new LottoPrinter();
        printer.PrintLottoMatchingResult(lottoShop, gambler);
    }
}
