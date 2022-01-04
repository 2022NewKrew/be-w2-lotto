package lotto.view;

import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultType;
import lotto.domain.lottocomponent.LottoTicket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import static lotto.view.printer.OutputPrinter.*;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> tickets, BufferedWriter wr) throws IOException {
        printLottoTicketTitle(tickets.size(), wr);
        for (LottoTicket ticket : tickets) {
            printLottoTicketNumbers(ticket, wr);
        }
    }

    public static void printLottoResult(LottoResult lottoResult, BufferedWriter wr) throws IOException {
        int lottoProfit = 0;
        printResultTitle(wr);
        for (LottoResultType resultType : LottoResultType.values()) {
            int matchCount = lottoResult.getMatchResult().get(resultType);
            printEachLottoResultType(resultType, matchCount, wr);
            lottoProfit += resultType.getMoney() * matchCount;
        }
        printLottoProfit(lottoResult.getPurchasePrice(), lottoProfit, wr);
        wr.flush();
    }

}
