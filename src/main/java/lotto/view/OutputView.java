package lotto.view;

import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultType;
import lotto.domain.component.LottoTicket;

import java.io.IOException;
import java.util.List;

import static lotto.view.printer.OutputPrinter.*;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> tickets) throws IOException {
        printLottoTicketTitle(tickets.size());
        for (LottoTicket ticket : tickets) {
            printLottoTicketNumbers(ticket);
        }
        printFlush();
    }

    public static void printLottoResult(LottoResult lottoResult) throws IOException {
        int lottoProfit = 0;
        printResultTitle();
        for (LottoResultType resultType : LottoResultType.values()) {
            int matchCount = lottoResult.getMatchResult().get(resultType);
            printEachLottoResultType(resultType, matchCount);
            lottoProfit += resultType.getMoney() * matchCount;
        }
        printLottoProfit(lottoResult.getPurchasePrice(), lottoProfit);
        printFlush();
    }

}
