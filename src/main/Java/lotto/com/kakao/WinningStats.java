package lotto.com.kakao;

import java.util.List;

public class WinningStats {

    private final static int[] WINNING_PRICE_LIST_BY_CORRECT_NUMBER = {0,0,0,5000,50000,1500000,2000000000};

    private final LottoBundle lottoBundle;
    private final List<Integer> lastWeekLottoNumberList;
    private final int lottoPurchaseMoney;

    public WinningStats(LottoBundle lottoBundle, List<Integer> lastWeekLottoNumberList, int lottoPurchaseMoney) {
        this.lottoBundle = lottoBundle;
        this.lastWeekLottoNumberList = lastWeekLottoNumberList;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
    }

    public double getProfitRatePercent(){
        return getProfit() * 100 / lottoPurchaseMoney;
    }

    private int getProfit(){
        int profit = 0;
        List<Lotto> LottoList = this.lottoBundle.getLottoList();
        for(Lotto lotto : LottoList)
            profit += WINNING_PRICE_LIST_BY_CORRECT_NUMBER[getLottoCorrectCount(lotto)];
        return profit;
    }

    private int getLottoCorrectCount(Lotto lotto) {
        int correctCount = 0;
        List<Integer> lottoNumberList = lotto.getLottoNumberList();
        for(int lottoNumber : lottoNumberList)
            correctCount += addCorrectCountOne(lottoNumber);
        return correctCount;
    }

    private int addCorrectCountOne(int lottoNumber){
        if(lastWeekLottoNumberList.contains(lottoNumber))
                return 1;
        return 0;
    }

    @Override
    public String toString(){
        return "";
    }
}
