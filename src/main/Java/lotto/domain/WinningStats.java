package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningStats {
    private final static int START_CORRECT_COUNT_BY_PRINT = 3;

    private final List<WinningPrice> winningPriceList;
    private final LottoBundle lottoBundle;
    private final List<Integer> lastWeekLottoNumberList;
    private final int lottoPurchaseMoney;
    private List<Integer> correctCountList;

    public WinningStats(LottoBundle lottoBundle, List<Integer> lastWeekLottoNumberList, int lottoPurchaseMoney) {
        this.lottoBundle = lottoBundle;
        this.lastWeekLottoNumberList = lastWeekLottoNumberList;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        this.winningPriceList = new ArrayList<>();

        setWinningPriceList();
        addCountInWinningPriceListAllLotto();
    }

    private void setWinningPriceList() {
        winningPriceList.add(WinningPrice.THREE);
        winningPriceList.add(WinningPrice.FOUR);
        winningPriceList.add(WinningPrice.FIVE);
        winningPriceList.add(WinningPrice.SIX);
    }

    private double getProfitRatePercent() {
        return getProfit() * 100 / lottoPurchaseMoney;
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
            addCountInWinningPriceList(getLottoCorrectCount(lotto));
        }
    }

    private void addCountInWinningPriceList(int lottoCorrectCount) {
        for (int i = 0; i < winningPriceList.size(); i++) {
            addCountInWinningPriceListByIndex(lottoCorrectCount, i);
        }
    }

    private void addCountInWinningPriceListByIndex(int lottoCorrectCount, int index) {
        if (lottoCorrectCount == index + START_CORRECT_COUNT_BY_PRINT) winningPriceList.get(index).addCount();
    }

    private int getLottoCorrectCount(Lotto lotto) {
        int correctCount = 0;
        List<Integer> lottoNumberList = lotto.getLottoNumberList();
        for (int lottoNumber : lottoNumberList)
            correctCount += addCorrectCountOne(lottoNumber);
        return correctCount;
    }

    private int addCorrectCountOne(int lottoNumber) {
        if (lastWeekLottoNumberList.contains(lottoNumber)) return 1;
        return 0;
    }

    public String printWinningStats() {
        StringBuilder stringBuilder = new StringBuilder();
        double profitRatePercent = getProfitRatePercent();

        for (WinningPrice winningPrice : winningPriceList) {
            stringBuilder.append(winningPrice.printWinningPrice());
        }

        stringBuilder.append("총 수익률은 ");
        stringBuilder.append((long)profitRatePercent);
        stringBuilder.append("%입니다.\n");

        return stringBuilder.toString();
    }
}
