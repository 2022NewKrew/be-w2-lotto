package view;

import domain.LottoResult;
import domain.LottoResultType;
import domain.LottoTicket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import static view.OutputPrinter.*;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> tickets, BufferedWriter wr) throws IOException {
        for (LottoTicket ticket : tickets) {
            printLottoTicketNumbers(ticket, wr);
        }
    }

    public static void printLottoResult(LottoResult lottoResult, BufferedWriter wr) throws IOException {
        int lottoProfit = 0;
        printResultTitle(wr);
        for (LottoResultType resultType : LottoResultType.values()) {
            Integer matchCount = lottoResult.getMatchResult().get(lottoResult);
            printEachLottoResultType(resultType, matchCount, wr);
            lottoProfit += resultType.getMoney() * matchCount;
        }
        printLottoProfit(lottoResult.getPurchasePrice(), lottoProfit, wr);
        wr.flush();
    }

}
