package view;

import domain.LottoTicket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class OutputPrinter {

    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";

    private OutputPrinter() {

    }

    public static void printLottoTicketNumbers(LottoTicket lottoTicket, BufferedWriter wr) throws IOException {
        wr.append(START_BRACKET+
                lottoTicket.getTickets().stream()
                        .map(lottoNumber->Integer.toString(lottoNumber.getNumber()))
                        .collect(Collectors.joining(","))
                +END_BRACKET);
        wr.newLine();
        wr.flush();
    }
}
