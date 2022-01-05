package lotto.view.printer;

import lotto.domain.result.LottoResultType;
import lotto.domain.component.LottoTicket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;

public class OutputPrinter {

    private static final BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private OutputPrinter() {
    }

    public static void printLottoTicketTitle(int numberOfManualLotto, int numberOfAutoLotto) throws IOException {
        wr.append("수동으로" + numberOfManualLotto + " 장, 자동으로" + numberOfAutoLotto + " 장을 구매했습니다.\n");
    }

    public static void printLottoTicketNumbers(LottoTicket lottoTicket) throws IOException {
        wr.append(LEFT_BRACKET +
                lottoTicket.getLottoNumbers().stream()
                        .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                        .collect(Collectors.joining(","))
                + RIGHT_BRACKET + "\n");
    }

    public static void printResultTitle() throws IOException {
        wr.append("당첨 통계\n");
        wr.append("------------\n");
    }

    public static void printEachLottoResultType(LottoResultType resultType, int matchingCount) throws IOException {
        wr.append(String.format(resultType.getFormatStrOfResult(),
                resultType.getMatchingNumberCount(), resultType.getMoney(), matchingCount));
    }

    public static void printLottoProfit(int purchasePrice, int lottoProfit) throws IOException {
        String profitRate = String.format("%.2f", (((double) lottoProfit / (double) purchasePrice) * 100) - 100);
        wr.append("총 수익률은 " + profitRate + "%입니다.");
    }

    public static void printFlush() throws IOException {
        wr.flush();
    }
}
