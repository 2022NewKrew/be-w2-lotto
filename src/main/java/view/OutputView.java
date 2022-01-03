package view;

import domain.Lotto;

import java.util.List;

public class OutputView {
    public void printAllLotto(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printWinningStats(List<Lotto> allLotto, List<Integer> winningNumbers) {

    }
}
