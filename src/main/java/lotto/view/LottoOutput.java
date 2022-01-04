package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoOutput {
    public void printLottoList(List<LottoNumbers> lottoList) {
        for (LottoNumbers lotto: lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(ArrayList<Integer> rewards, ArrayList<Integer> results, int money) {
        int winningPrice = 0;
        double yield;
        System.out.println("\n당첨 통계");
        System.out.println("-------------------");
        for (int sameCount = 3; sameCount < 7; sameCount++) {
            winningPrice += rewards.get(sameCount) * results.get(sameCount);
            System.out.printf("%d개 일치 (%d원)- %d개\n", sameCount, rewards.get(sameCount), results.get(sameCount));
        }
        yield = (double) (winningPrice - money) / money * 100;
        System.out.printf("총 수익율은 %.2f%% 입니다.", yield);
    }
}
