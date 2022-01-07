package lotto.domain.winningstats;

import lotto.domain.winningstats.lastweeknumber.LastWeekNumber;
import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.winningstate.WinningState;
import lotto.domain.winningstats.winningprice.WinningPrice;

import java.util.HashMap;
import java.util.List;

public class WinningStats {
    private final HashMap<WinningState, WinningPrice> winningPriceHashMap;
    private final LottoBundle lottoBundle;
    private final LastWeekNumber lastWeekNumber;

    public WinningStats(LottoBundle lottoBundle, List<Integer> lastWeekLottoNumberList, int bonusBall) {
        this.lottoBundle = lottoBundle;
        this.winningPriceHashMap = new HashMap<>();
        this.lastWeekNumber = new LastWeekNumber(lastWeekLottoNumberList, bonusBall);
        setWinningPriceHashMap();
        addCountInWinningPriceHashMapAllLotto();
    }

    private void setWinningPriceHashMap() {
        winningPriceHashMap.put(new WinningState(3), WinningPrice.THREE);
        winningPriceHashMap.put(new WinningState(4), WinningPrice.FOUR);
        winningPriceHashMap.put(new WinningState(5, false), WinningPrice.FIVE);
        winningPriceHashMap.put(new WinningState(5, true), WinningPrice.FIVE_BONUS);
        winningPriceHashMap.put(new WinningState(6), WinningPrice.SIX);
    }

    private double getProfitRatePercent() {
        return ((getProfit() - lottoBundle.getLottoPurchaseMoney()) * 100) / lottoBundle.getLottoPurchaseMoney();
    }

    private long getProfit() {
        long profit = 0;
        for (WinningPrice winningPrice : winningPriceHashMap.values()) {
            profit += winningPrice.calculateProfit();
        }
        return profit;
    }

    private void addCountInWinningPriceHashMapAllLotto() {
        List<Lotto> LottoList = this.lottoBundle.getLottoList();
        for (Lotto lotto : LottoList) {
            addCountInWinningPrice(getLottoCorrectCount(lotto), isBonusBall(lotto));
        }
    }

    private boolean isBonusBall(Lotto lotto) {
        return lotto.getLottoNumberList().contains(lastWeekNumber.getBonusBall());
    }

    private void addCountInWinningPrice(int lottoCorrectCount, boolean isBonusBallInLotto) {
        WinningState winningStateKey = new WinningState(lottoCorrectCount, isBonusBallInLotto);
        if (winningPriceHashMap.containsKey(winningStateKey))
            winningPriceHashMap.get(winningStateKey).addCount();
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

        for (WinningPrice winningPrice : winningPriceHashMap.values()) {
            stringBuilder.append(winningPrice.printWinningPrice());
        }

        stringBuilder.append("총 수익률은 ");
        stringBuilder.append((long) profitRatePercent);
        stringBuilder.append("%입니다.\n");

        return stringBuilder.toString();
    }
}
