package com.upperleaf.domain;

import com.upperleaf.domain.lotto.Lottos;
import com.upperleaf.domain.lotto.RandomLottoStrategy;

public class LottoSeller {

    private final int lottoPrice;

    public LottoSeller(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    /**
     * 지불 방법에 따라 Lottos 객체를 생성하는 메서드
     * @param paymentInfo 사용자가 지불한 정보를 표현하는 객체
     * @return 사용자가 지불한 금액에 따라 적절한 개수의 로또를 포함하는 Lottos 객체 반환
     */
    public Lottos sell(LottoPaymentInfo paymentInfo) {
        long amount = getLottoAmount(paymentInfo);
        return Lottos.createLottos(amount, new RandomLottoStrategy());
    }

    private long getLottoAmount(LottoPaymentInfo paymentInfo) {
        return paymentInfo.getPaymentAmount() / lottoPrice;
    }
}
