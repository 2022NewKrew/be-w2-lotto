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

    public void addAutoTickets(Money money) {
        autoAmount = money.calculateAmount(LottoTicket.PRICE);
        lottoTickets.addAll(autoAmount.makeLottoTicket(new RandomTicketGenerator()));
    }

    public Money addManualTickets(List<List<Integer>> inputs, Money money, Amount manualAmount) throws IllegalArgumentException {
        Money leftMoney = money.sub(manualAmount.fullPrice(LottoTicket.PRICE));
        this.manualAmount = manualAmount;
        lottoTickets.addAll(manualAmount.makeLottoTicket(new ManualTicketGenerator(inputs, manualAmount)));
        return leftMoney;
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

    public List<String> getLottoTicketsForWeb() {
        List<String> stringList = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets)
            stringList.add(lottoTicket.toString());
        return stringList;
    }

}
