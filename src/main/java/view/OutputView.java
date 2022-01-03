package view;

import domain.Lotto;

import java.util.List;

public class OutputView {
    StringBuilder stringBuilder = new StringBuilder();

    public void printAllLotto(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.toString());
        }
    }
}
