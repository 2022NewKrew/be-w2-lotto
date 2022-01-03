package view;

import domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void printAllLotto(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printWinningStats(List<String> winningStatsStrings) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (String winningStatsString : winningStatsStrings) {
            System.out.println(winningStatsString);
        }
    }
}
