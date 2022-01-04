package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.LottoPaymentInfo;
import com.upperleaf.domain.lotto.Lotto;

public class CustomLottoStrategy implements LottoCreateStrategy {

    private final LottoCreateStrategy randomStrategy = new RandomLottoStrategy();
    private final LottoCreateStrategy manualStrategy = new LottoCreateStrategyRetry(new ManualLottoStrategy());

    private final int manualNum;
    private int manualCount = 0;

    public CustomLottoStrategy(LottoPaymentInfo paymentInfo) {
        this.manualNum = paymentInfo.getManualNum();
    }

    @Override
    public Lotto createLotto() {
        if(manualCount == 0 && manualCount < manualNum) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        if(manualCount < manualNum) {
            manualCount++;
            return manualStrategy.createLotto();
        }
        return randomStrategy.createLotto();
    }
}
