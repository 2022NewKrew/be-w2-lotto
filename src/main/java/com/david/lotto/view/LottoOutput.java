package com.david.lotto.view;

import com.david.lotto.Lotto;
import com.david.lotto.LottoCalculate;

import java.util.List;

public class LottoOutput {

    public void printLottoCount(int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장 , 자동으로 %d개를 구매했습니다.%n",manualCount,autoCount);
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
