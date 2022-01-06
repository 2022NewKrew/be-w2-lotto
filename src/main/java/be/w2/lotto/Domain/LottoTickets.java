package be.w2.lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;
    Amount manualAmount;
    Amount autoAmount;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void addAutoTickets(Money money, LottoMaker lottoMaker) {
        autoAmount = LottoTicket.calculateAmount(money);
        lottoTickets.addAll(autoAmount.makeLottoTicket(new RandomTicketGenerator(lottoMaker)));
    }

    public void addManualTickets(List<List<Integer>> inputs, Money money, Amount manualAmount) throws IllegalArgumentException {
        LottoTicket.subMoney(manualAmount, money);
        this.manualAmount = manualAmount;
        lottoTickets.addAll(manualAmount.makeLottoTicket(new ManualTicketGenerator(inputs, manualAmount)));
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public String toString() {
        return lottoTickets.toString();
    }

    public LottoResult calculateResult(LottoNumbers answers, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            int hit = lottoTicket.calculateTicket(answers);
            boolean isBonus = lottoTicket.contains(bonusNumber);
            lottoResult.add(Prize.valueOf(hit, isBonus));
        }
        return lottoResult;
    }

    public int getManualAmount() {
        return manualAmount.getAmount();
    }

    public int getAutoAmount() {
        return autoAmount.getAmount();
    }
}
