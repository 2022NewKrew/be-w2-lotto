package be.w2.lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("개수는 음수일 수 없습니다!");
        }
        this.amount = amount;
    }

    public int fullPrice(int price) {
        return amount * price;
    }

    public int getAmount() {
        return amount;
    }

    public List<LottoTicket> makeRandomLottoTicket(LottoMaker lottoMaker) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++)
            lottoTickets.add(lottoMaker.makeLottoTicket());
        return lottoTickets;
    }

    public List<LottoTicket> makeManualLottoTicket(List<List<Integer>> inputs) throws IllegalArgumentException {
        if (inputs == null || amount != inputs.size())
            throw new IllegalArgumentException();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (List<Integer> input : inputs)
            lottoTickets.add(LottoTicket.getInstanceByIntList(input));
        return lottoTickets;
    }
}
