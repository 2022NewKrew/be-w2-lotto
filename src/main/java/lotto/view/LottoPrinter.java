package lotto.view;

import lotto.domain.Constants;
import lotto.domain.Rank;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오전 11:09
 */
public class LottoPrinter {
    private LottoPrinter() {
        // instance 생성 제한
    }

    public static void printLottoAmount(Integer lottoAmount) {
        System.out.println(String.format(Constants.PRINT_PURCHASE_LOTTO_FORMAT, lottoAmount));
    }

    public static void printLottoStatisticsTitle() {
        System.out.println(Constants.PRINT_WINNING_STATISTICS);
    }

    public static void printLottoRankResult(Rank rank, Integer countOfMatched) {
        System.out.println(String.format(Constants.PRINT_MATCHED_FORMAT,
                rank.getMatchString(), rank.getWinningMoney(), countOfMatched));
    }

    public static void printLottoYield(long winningAmount, int purchaseAmount) {
        float lottoYield = 100 * (winningAmount - purchaseAmount) / purchaseAmount;
        System.out.println(String.format(Constants.PRINT_YIELD_FORMAT, lottoYield));
    }
}
