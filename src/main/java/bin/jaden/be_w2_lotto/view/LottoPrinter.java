package bin.jaden.be_w2_lotto.view;

import bin.jaden.be_w2_lotto.LottoGame.LottoGame;
import bin.jaden.be_w2_lotto.domain.Constants;
import bin.jaden.be_w2_lotto.domain.LottoGameManager;
import bin.jaden.be_w2_lotto.domain.LottoRankEnum;

import java.util.List;
import java.util.Map;

public class LottoPrinter {
    private LottoPrinter() {
        // instance 생성 제한용 생성자
    }

    public static void printLottoData(LottoGameManager lottoGameManager) {
        List<LottoGame> lottoGames = lottoGameManager.getLottoGames();
        System.out.printf(Constants.PRINT_LOTTO_GAMES_SIZE_FORMAT, lottoGameManager.getNumberOfPurchaseManually(), lottoGameManager.getNumberOfPurchaseAuto());
        for (LottoGame lottoGame : lottoGames) {
            lottoGame.printNumbers();
        }
    }

    public static void printResults(int purchasingAmount, Map<LottoRankEnum, Integer> result) {
        System.out.println(Constants.PRINT_RESULT_TITLE);
        long totalRewards = 0;
        for (int i = 3; i <= 7; i++) {
            LottoRankEnum rank = LottoRankEnum.values()[i - 2];
            int count = result.getOrDefault(rank, 0);
            System.out.println(rank.getPrintString(count));
            totalRewards += (long) rank.getReward() * count;
        }
        System.out.printf(Constants.PRINT_TOTAL_REWARD_RATIO_FORMAT, (totalRewards - purchasingAmount) * 100 / purchasingAmount);
    }

}
