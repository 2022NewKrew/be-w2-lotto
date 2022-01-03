package be.w2.lotto.Domain;


public class LottoSeller {

    private final LottoMaker lottoMaker;

    public LottoSeller(LottoMaker lottoMaker) {
        this.lottoMaker = lottoMaker;
    }

    LottoTickets sell(Money money) {
        int amount = money.calculateAmount(LottoTicket.PRICE);
        LottoTickets lottoTickets = new LottoTickets(amount, lottoMaker);
        return lottoTickets;
    }

}
