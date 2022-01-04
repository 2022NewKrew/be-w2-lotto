package bin.jaden.be_w2_lotto.view;

import bin.jaden.be_w2_lotto.domain.Constants;
import bin.jaden.be_w2_lotto.domain.Lotto;
import bin.jaden.be_w2_lotto.domain.LottoGame;
import bin.jaden.be_w2_lotto.domain.LottoRankEnum;

import java.util.List;
import java.util.Map;

public class LottoPrinter {
    private LottoPrinter() {
        // instance 생성 제한용 생성자
    }

    public static void printLottoData(Lotto lotto) {
        List<LottoGame> lottoGames = lotto.getLottoGames();
        System.out.printf(Constants.PRINT_LOTTO_GAMES_SIZE_FORMAT, lottoGames.size());
        for (LottoGame lottoGame : lottoGames) {
            lottoGame.printNumbers();
        }
    }

    public static void printResults(int purchasingAmount, Map<LottoRankEnum, Integer> result) {
        System.out.println(Constants.PRINT_RESULT_TITLE);
        int[] rewards = {5000, 50000, 1500000, 30000000, 2000000000};
        int totalRewards = 0;
        for (int i = 3; i <= 7; i++) {
            LottoRankEnum rank = LottoRankEnum.values()[i - 3];
            int reward = rewards[i - 3];
            int count = result.getOrDefault(rank, 0);
            System.out.println(getResultString(i, reward, count, rank));
            totalRewards += reward * count;
        }
        System.out.printf(Constants.PRINT_TOTAL_REWARD_RATIO_FORMAT, totalRewards * 100 / purchasingAmount);
    }

    public static String getResultString(int index, int reward, int count, LottoRankEnum rank) {
        if (rank == LottoRankEnum.LOTTO_RANK_1ST) {
            return String.format(Constants.PRINT_RESULT_FORMAT, index - 1, reward, count);
        }
        if (rank == LottoRankEnum.LOTTO_RANK_2ND) {
            return String.format(Constants.PRINT_2ND_RESULT_FORMAT, index - 1, reward, count);
        }
        return String.format(Constants.PRINT_RESULT_FORMAT, index, reward, count);
    }

}
