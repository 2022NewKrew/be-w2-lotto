package lotto;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoStore {
    private LottoCreater lottoCreater;

    public LottoStore(LottoCreater lottoCreater) {
        this.lottoCreater = lottoCreater;
    }

    public void setLottoCreater(LottoCreater lottoCreater) {
        this.lottoCreater = lottoCreater;
    }

    public List<LottoTicket> buy(int amount) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tickets.add(lottoCreater.create());
        }
        return tickets;
    }
}
