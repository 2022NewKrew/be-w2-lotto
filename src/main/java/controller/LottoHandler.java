package controller;

import model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoHandler {

    private static int RANK_MAX_COUNT = 5;

    private LottoHandler() {
    }

    public static List<Integer> getRankResults(List<Integer> lastWeeksWinningNumber, int bonusNumber, List<Lotto> lottos) {
        List<Integer> ranks = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (Lotto lotto : lottos) {
            int idx = compareLottos(lastWeeksWinningNumber, bonusNumber, lotto.getNumbers());
            ranks.set(idx, ranks.get(idx) + 1);
        }

        return ranks.subList(0, RANK_MAX_COUNT);
    }

    public static long getTotalWinningAmount(List<Integer> rankResults){
        List<Integer> rankPrices = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000));
        long totalWinningAmount = 0;

        for (int i = 0; i < RANK_MAX_COUNT; i++) {
            totalWinningAmount += rankPrices.get(i) * rankResults.get(i);
        }

        return totalWinningAmount;
    }

    private static int compareLottos(List<Integer> lastWeeksWinningNumber, int bonusNumber, List<Integer> curLotto) {
        int correctNumberCount = 0;
        int bonus = 0;

        for (int num : lastWeeksWinningNumber) {
            correctNumberCount += compareLottoNumbers(num, curLotto);
        }
        bonus += compareLottoNumbers(bonusNumber, curLotto);

        // 1등인 경우 순서를 위해 예외적으로 처리
        if (correctNumberCount == 6) {
            correctNumberCount = 7;
        }
        // 2등인 경우 순서를 위해 예외적으로 처리
        if (correctNumberCount == 5 && bonus == 1) {
            correctNumberCount = 6;
        }

        // 당첨되지 않는 경우는 하나로 정해 리턴
        if (correctNumberCount <= 2) {
            return 5;
        }

        return correctNumberCount - 3;
    }

    private static int compareLottoNumbers(int num, List<Integer> lotto) {
        if (lotto.contains(num)) {
            return 1;
        }
        return 0;
    }
}
