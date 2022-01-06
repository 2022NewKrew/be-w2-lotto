package lotto.vo;

import java.math.BigDecimal;
import lotto.domain.LottoMoney;

public class LottoMoneyVo {

    private final LottoMoney lottoMoney;

    public LottoMoneyVo(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public int purchase() {
        return lottoMoney.purchase();
    }

    public BigDecimal profit(BigDecimal totalMoney) {
        return lottoMoney.profit(totalMoney);
    }
}
