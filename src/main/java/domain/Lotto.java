package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final int LOTTO_PRICE = 1000;

    public Lotto() {}

    public int getLottoCnt(int money) {
        return money / LOTTO_PRICE;
    }

    public List<List> getLottoTickets(int lottoCnt) {
        List<List> ticketList = new ArrayList<>();
        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < lottoCnt; i++) {
            ticketList.add(lottoTicket.makeRandomLottoNumbers());
        }
        return ticketList;
    }

    public int getLOTTO_PRICE(){
        return LOTTO_PRICE;
    }
}
