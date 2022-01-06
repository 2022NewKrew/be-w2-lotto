package be.w2.lotto.Domain;

public class RandomTicketGenerator implements TicketGenerator {

    private final LottoMaker lottoMaker;

    public RandomTicketGenerator(LottoMaker lottoMaker) {
        this.lottoMaker = lottoMaker;
    }

    @Override
    public LottoTicket generate() {
        return lottoMaker.makeLottoTicket();
    }
}
