package be.w2.lotto.Domain;


import java.util.List;

public class LottoSeller {

    private final LottoMaker lottoMaker;

    public LottoSeller(LottoMaker lottoMaker) {
        this.lottoMaker = lottoMaker;
    }


    private void sellManual(List<List<Integer>> manualNumbers, Money money, LottoTickets lottoTickets, Amount amount) {
        lottoTickets.addManualTickets(manualNumbers, money, amount);
    }

    private void sellAuto(Money money, LottoTickets lottoTickets) {
        lottoTickets.addAutoTickets(money, lottoMaker);
    }

    public LottoTickets sell(List<List<Integer>> manualNumbers, Money money, Amount manualAmount) {

        LottoTickets lottoTickets = new LottoTickets();
        sellManual(manualNumbers, money, lottoTickets, manualAmount);
        sellAuto(money, lottoTickets);
        return lottoTickets;
    }

}
