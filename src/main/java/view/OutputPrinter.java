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
        wr.append(LEFT_BRACKET+
                lottoTicket.getTickets().stream()
                        .map(lottoNumber->Integer.toString(lottoNumber.getNumber()))
                        .collect(Collectors.joining(","))
                +RIGHT_BRACKET+"\n");
        wr.flush();
    }

    public static void printResultTitle(BufferedWriter wr) throws IOException{
        wr.append("당첨 통계\n");
        wr.append("------------\n");
    }

    public static void printEachLottoResultType(LottoResultType resultType,int matchCount,BufferedWriter wr) throws IOException {
        wr.append(resultType.getMatchNumberCount()+"개 일치 ("+
                resultType.getMoney()
                +") -" +matchCount +"개");
    }

    public static void printLottoProfit(int purchasePrice,int lottoProfit, BufferedWriter wr) throws IOException {
        wr.append("총 수익률은"+ purchasePrice / lottoProfit +"입니다.");
    }
}
