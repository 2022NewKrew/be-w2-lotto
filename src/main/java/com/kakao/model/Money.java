package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.MoneyRangeException;

public class Money {

    private int money;

    public Money(Integer money) throws MoneyRangeException {
        checkMoneyRange(money);
        this.money = money;
    }

    // 유효성 검사
    private void checkMoneyRange(Integer moneyToBuyLottos) throws MoneyRangeException {
        if( moneyToBuyLottos == null || moneyToBuyLottos < LottoData.PRICE_OF_LOTTO ) {
            throw new MoneyRangeException();
        }
    }

    // getter
    public int getMoney() {
        return money;
    }
}
