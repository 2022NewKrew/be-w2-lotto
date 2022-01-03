package bin.jaden.be_w2_lotto.view;

import bin.jaden.be_w2_lotto.domain.Constants;
import bin.jaden.be_w2_lotto.domain.Lotto;

import java.util.List;

public class LottoPrinter {
    private LottoPrinter() {
        // instance 생성 제한용 생성자
    }

    public static void printLottoData(Lotto lotto) {
        List<List<Integer>> lottoGames = lotto.getLottoGames();
        System.out.printf(Constants.PRINT_LOTTO_GAMES_SIZE_FORMAT, lottoGames.size());
        for (List<Integer> lottoGame : lottoGames) {
            System.out.println(lottoGame);
        }
    }

    public static void printResult(int purchasingAmount, List<Integer> result) {
        System.out.println(Constants.PRINT_RESULT_TITLE);
        int[] rewards = {5000, 50000, 1500000, 2000000000};
        int totalRewards = 0;
        for (int i = 3; i <= 6; i++) {
            int reward = rewards[i - 3];
            int count = result.get(i);
            System.out.printf(Constants.PRINT_RESULT_FORMAT, i, reward, count);
            totalRewards += reward * count;
        }
        System.out.printf(Constants.PRINT_TOTAL_REWARD_RATIO_FORMAT, totalRewards * 100 / purchasingAmount);
    }
}
