package view;

import domain.LottoTicket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> tickets,BufferedWriter wr) throws IOException {
        for(LottoTicket ticket:tickets){
            OutputPrinter.printLottoTicketNumbers(ticket,wr);
        }
    }


}
