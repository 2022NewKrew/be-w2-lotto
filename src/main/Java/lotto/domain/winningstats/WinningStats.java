package lotto.domain.winningstats;

import lotto.domain.winningstats.lottobundle.LastWeekNumberBundle;
import lotto.domain.winningstats.lottobundle.LottoList;
import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.winningstate.WinningState;
import lotto.domain.winningstats.winningprice.WinningPrice;

import java.util.HashMap;
import java.util.Iterator;

public class WinningStats {
    private final HashMap<WinningState, WinningPrice> winningPriceHashMap;
    private final LottoBundle lottoBundle;
    private final LastWeekNumberBundle lastWeekWinLotto;

    public WinningStats(LottoBundle lottoBundle, Lotto lastWeekWinLotto, int bonusBall) {
        this.lottoBundle = lottoBundle;
        this.winningPriceHashMap = new HashMap<>();
        this.lastWeekWinLotto = new LastWeekNumberBundle(lastWeekWinLotto, bonusBall);
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
        LottoList lottoList = this.lottoBundle.getLottoList();
        Iterator<Lotto> lottoIterator = lottoList.getIterator();
        while (lottoIterator.hasNext()) {
            Lotto lotto = lottoIterator.next();
            addCountInWinningPrice(getLottoCorrectCount(lotto), isBonusBall(lotto));
        }
    }

    private boolean isBonusBall(Lotto lotto) {
        return lotto.contains(lastWeekWinLotto.getBonusBall());
    }

    private void addCountInWinningPrice(int lottoCorrectCount, boolean isBonusBallInLotto) {
        WinningState winningStateKey = new WinningState(lottoCorrectCount, isBonusBallInLotto);
        if (winningPriceHashMap.containsKey(winningStateKey))
            winningPriceHashMap.get(winningStateKey).addCount();
    }

    private int getLottoCorrectCount(Lotto lotto) {
        int correctCount = 0;
        correctCount += lotto.getCorrectCount(lastWeekWinLotto);
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
