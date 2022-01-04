package view;

import domain.LottoResultType;
import domain.LottoTicket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class OutputPrinter {

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private OutputPrinter() {

    }

    public static void printLottoTicketNumbers(LottoTicket lottoTicket, BufferedWriter wr) throws IOException {
        wr.append(LEFT_BRACKET +
                lottoTicket.getLottoNumbers().stream()
                        .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                        .collect(Collectors.joining(","))
                + RIGHT_BRACKET + "\n");
        wr.flush();
    }

    public static void printResultTitle(BufferedWriter wr) throws IOException {
        wr.append("당첨 통계\n");
        wr.append("------------\n");
    }

    public static void printEachLottoResultType(LottoResultType resultType, int matchingCount, BufferedWriter wr) throws IOException {
        wr.append(resultType.getMatchingNumberCount() + "개 일치 (" +
                resultType.getMoney()
                + ") - " + matchingCount + "개\n");
    }

    public static void printLottoProfit(int purchasePrice, int lottoProfit, BufferedWriter wr) throws IOException {
        String profitRate = String.format("%.2f", ((double) lottoProfit / (double) purchasePrice) * 100);
        wr.append("총 수익률은 " + profitRate + "%입니다.");
    }
}
