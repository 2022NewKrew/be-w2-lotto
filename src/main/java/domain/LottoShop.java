package domain;

import constant.Constants;
import service.LottoGenerator;

public class LottoShop {

    private final LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto sell(int money) {
        return lottoGenerator.makeLotto(getNumberOfLottoTicket(money));
    }

    private int getNumberOfLottoTicket(int money) {
        return money / Constants.LOTTO_PRICE;
    }

}
