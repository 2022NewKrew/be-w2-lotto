package lotto.view;

import lotto.domain.Constants;
import lotto.domain.Rank;

import java.math.BigDecimal;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오전 11:09
 */
public class LottoPrinter {
    private LottoPrinter() {
        // instance 생성 제한
    }

    public static void printLottoAmount(Integer manualLottoCount, Integer autoLottoCount) {
        System.out.println(String.format(Constants.PRINT_PURCHASE_LOTTO_FORMAT, manualLottoCount, autoLottoCount));
    }

    public static void printManualLotto() {
        System.out.println(Constants.INPUT_MANUAL_LOTTO_MESSAGE);
    }

    public static void printLottoStatisticsTitle() {
        System.out.println(Constants.PRINT_WINNING_STATISTICS);
    }

    public static void printLottoRankResult(Rank rank, Integer countOfMatched) {
        System.out.println(String.format(Constants.PRINT_MATCHED_FORMAT,
                rank.getMatchString(), rank.getWinningMoney(), countOfMatched));
    }

    public static void printLottoYield(BigDecimal totalRateOfReturn) {
        System.out.println(String.format(Constants.PRINT_YIELD_FORMAT, totalRateOfReturn));
    }
}
