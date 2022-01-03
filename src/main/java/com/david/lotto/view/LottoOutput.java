package com.david.lotto.view;

import com.david.lotto.domain.LottoCalculate;
import com.david.lotto.domain.LottoMachine;

public class LottoOutput {

    public void printLottoCount(int amount, int lottoPrice) {
        System.out.println(amount / lottoPrice + "개를 구매했습니다.");
    }

    public void printLottoInfo(LottoMachine lottoMachine) {
        System.out.println(lottoMachine);
        System.out.println();
    }

    public void printLottoResult(LottoCalculate lottoCalculate, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoCalculate);
        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "% 입니다.");
    }

}
