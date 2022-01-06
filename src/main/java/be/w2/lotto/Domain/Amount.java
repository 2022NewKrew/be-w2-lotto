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

    public boolean isValidLength(List<List<Integer>> inputs) {
        return amount == inputs.size();
    }

    public List<LottoTicket> makeLottoTicket(TicketGenerator ticketGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++)
            lottoTickets.add(ticketGenerator.generate());
        return lottoTickets;
    }

}
