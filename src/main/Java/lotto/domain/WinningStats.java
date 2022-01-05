package lotto.domain;

import lotto.domain.lottobundle.lotto.Lotto;
import lotto.domain.lottobundle.LottoBundle;
import lotto.domain.winningprice.WinningPrice;

import java.util.ArrayList;
import java.util.List;

public class WinningStats {
    private final int SECOND_RANK_CORRECT_NUMBER = 5;
    private final List<WinningPrice> winningPriceList;
    private final LottoBundle lottoBundle;
    private final int lottoPurchaseMoney;
    private final LastWeekNumber lastWeekNumber;

    public WinningStats(LottoBundle lottoBundle, List<Integer> lastWeekLottoNumberList, int lottoPurchaseMoney, int bonusBall) {
        this.lottoBundle = lottoBundle;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        this.winningPriceList = new ArrayList<>();
        this.lastWeekNumber = new LastWeekNumber(lastWeekLottoNumberList, bonusBall);
        setWinningPriceList();
        addCountInWinningPriceListAllLotto();
    }

    private void setWinningPriceList() {
        winningPriceList.add(WinningPrice.THREE);
        winningPriceList.add(WinningPrice.FOUR);
        winningPriceList.add(WinningPrice.FIVE);
        winningPriceList.add(WinningPrice.FIVE_BONUS);
        winningPriceList.add(WinningPrice.SIX);
    }

    private double getProfitRatePercent() {
        return ((getProfit() - lottoPurchaseMoney) * 100) / lottoPurchaseMoney;
    }

    private long getProfit() {
        long profit = 0;
        for (WinningPrice winningPrice : winningPriceList) {
            profit += winningPrice.calculateProfit();
        }
        return profit;
    }

    private void addCountInWinningPriceListAllLotto() {
        List<Lotto> LottoList = this.lottoBundle.getLottoList();
        for (Lotto lotto : LottoList) {
            addCountInWinningPriceList(getLottoCorrectCount(lotto), isBonusBall(lotto));
        }
    }

    private boolean isBonusBall(Lotto lotto) {
        return lotto.getLottoNumberList().contains(lastWeekNumber.getBonusBall());
    }

    private void addCountInWinningPriceList(int lottoCorrectCount, boolean isBonusBallInLotto) {
        for (WinningPrice winningPrice : winningPriceList) {
            addCountInWinningPriceListByIndex(lottoCorrectCount, isBonusBallInLotto, winningPrice);
        }
    }

    private boolean isSecondRank(int lottoCorrectCount, boolean isBonusBallInLotto) {
        return (lottoCorrectCount == SECOND_RANK_CORRECT_NUMBER && isBonusBallInLotto);
    }

    private void addCountInWinningPriceListByIndex(int lottoCorrectCount, boolean isBonusBallInLotto, WinningPrice winningPrice) {
        if (isSecondRank(lottoCorrectCount, isBonusBallInLotto) && lottoCorrectCount == winningPrice.getCorrectCount()) {
            winningPrice.addCount();
            return;
        }

        if (lottoCorrectCount == winningPrice.getCorrectCount()) {
            winningPrice.addCount();
            return;
        }
    }

    private int getLottoCorrectCount(Lotto lotto) {
        int correctCount = 0;
        List<Integer> lottoNumberList = lotto.getLottoNumberList();
        for (int lottoNumber : lottoNumberList)
            correctCount += lastWeekNumber.addOneIfContains(lottoNumber);
        return correctCount;
    }

    public String printWinningStats() {
        StringBuilder stringBuilder = new StringBuilder();
        double profitRatePercent = getProfitRatePercent();

        for (WinningPrice winningPrice : winningPriceList) {
            stringBuilder.append(winningPrice.printWinningPrice());
        }

        stringBuilder.append("총 수익률은 ");
        stringBuilder.append((long) profitRatePercent);
        stringBuilder.append("%입니다.\n");

        return stringBuilder.toString();
    }
}
