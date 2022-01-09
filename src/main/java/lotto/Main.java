package lotto;

import lotto.domain.LottoController;
import lotto.domain.Ticket;

public class Main {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.lottoGameStart(Ticket.TICKET_PRICE);
    }
}
