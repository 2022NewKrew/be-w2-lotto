package com.david.lotto.view;

import com.david.lotto.Lotto;
import com.david.lotto.LottoCalculate;

import java.util.List;

public class LottoOutput {

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoInfo(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
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
