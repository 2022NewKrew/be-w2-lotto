package lotto.view;

import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultType;
import lotto.domain.component.LottoTicket;
import lotto.dto.PurChasingLottoDTO;

import java.io.IOException;


import static lotto.view.printer.OutputPrinter.*;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTickets(PurChasingLottoDTO purChasingLottoDTO) throws IOException {
        printLottoTicketTitle(purChasingLottoDTO.getNumberOfManualLotto(), purChasingLottoDTO.getNumberOfAutoLotto());
        for (LottoTicket ticket : purChasingLottoDTO.getLottoTickets()) {
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
