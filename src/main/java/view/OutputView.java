package main.java.view;

import main.java.controller.LottoGenerator;
import main.java.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            printLotto(lottos.get(i));
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printLottoWinningStats(List<Integer> lastWeeksWinningNumber, List<Lotto> lottos) {
        List<String> rankPrice = new ArrayList<>(Arrays.asList("5000", "50000", "1500000", "2000000000"));
        List<Integer> ranks = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            int idx = compareLottos(lastWeeksWinningNumber, lotto.getNumbers());
            if (idx < 4) {
                ranks.set(idx, ranks.get(idx) + 1);
            }
        }

        System.out.println("\n당첨 통계\n----------");
        for (int i = 0; i < ranks.size(); i++) {
            System.out.println((i + 3) + "개 일치 (" + rankPrice.get(i) + "원)- " + ranks.get(i) + "개");
        }
    }

    private static int compareLottos(List<Integer> lastWeeksWinningNumber, List<Integer> curLotto) {
        int correctNumberCount = 0;

        for (int num : lastWeeksWinningNumber) {
            if (curLotto.contains(num)) {
                correctNumberCount++;
            }
        }

        if (correctNumberCount == 6) {
            return 3;
        } else if (correctNumberCount == 5) {
            return 2;
        } else if (correctNumberCount == 4) {
            return 1;
        } else if (correctNumberCount == 3) {
            return 0;
        }

        return 4;
    }
}
