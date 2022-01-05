package domain;

import constant.Constants;
import service.LottoGenerator;

import java.util.List;

public class LottoShop {

    private final LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto sell(List<LottoTicket> manualLottoTickets, int money) {
        return lottoGenerator.makeLotto(manualLottoTickets,
                getNumberOfAutoLottoTicket(getNumberOfLottoTicket(money), manualLottoTickets.size()));
    }

    private int getNumberOfAutoLottoTicket(int numberOfLottoTicket, int numberOfManualLottoTicket) {
        return numberOfLottoTicket - numberOfManualLottoTicket;
    }

    private int getNumberOfLottoTicket(int money) {
        return money / Constants.LOTTO_PRICE;
    }

}
