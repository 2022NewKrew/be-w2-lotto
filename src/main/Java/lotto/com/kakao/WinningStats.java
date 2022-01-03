package lotto.com.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningStats {
    private final static int START_CORRECT_COUNT_BY_PRINT = 3;

    private enum Winning_price{
        ZERO(0),ONE(0),TWO(0),THREE(5000),FOUR(50000),FIVE(1500000),FIVE_BONUS(30000000),SIX(2000000000);

        private final long winnigPrice;
        Winning_price(long winnigPrice) {
            this.winnigPrice = winnigPrice;
        }
        public long getWinnigPrice(){
            return winnigPrice;
        }
    }
    private final static long[] WINNING_PRICE_ARRAY_BY_CORRECT_NUMBER = {0,0,0,5000,50000,1500000,2000000000};
    private final static List<Long> WINNING_PRICE_LIST_BY_CORRECT_NUMBER =  Arrays.stream(WINNING_PRICE_ARRAY_BY_CORRECT_NUMBER).boxed().collect(Collectors.toList());

    private final LottoBundle lottoBundle;
    private final List<Integer> lastWeekLottoNumberList;
    private final int lottoPurchaseMoney;
    private List<Integer> correctCountList;

    public WinningStats(LottoBundle lottoBundle, List<Integer> lastWeekLottoNumberList, int lottoPurchaseMoney) {
        this.lottoBundle = lottoBundle;
        this.lastWeekLottoNumberList = lastWeekLottoNumberList;
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        this.correctCountList = getLottoCorrectCountList();
        correctCountList = Collections.unmodifiableList(correctCountList);
    }

    private double getProfitRatePercent(){
        return getProfit() * 100 / lottoPurchaseMoney;
    }

    private long getProfit(){
        long profit = 0;
        for (int i = 0; i < WINNING_PRICE_LIST_BY_CORRECT_NUMBER.size(); i++) {
            profit += WINNING_PRICE_LIST_BY_CORRECT_NUMBER.get(i) * correctCountList.get(i);
        }
        return profit;
    }

    private List<Integer> getLottoCorrectCountList(){
        List<Lotto> LottoList = this.lottoBundle.getLottoList();
        int[] correctCountArray = {0,0,0,0,0,0,0};
        for(Lotto lotto : LottoList)
            correctCountArray[getLottoCorrectCount(lotto)] += 1;
        return Arrays.stream(correctCountArray).boxed().collect(Collectors.toList());
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
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=START_CORRECT_COUNT_BY_PRINT;i<correctCountList.size();i++) {
            stringBuilder.append(i);
            stringBuilder.append("개 일치 (");
            stringBuilder.append(WINNING_PRICE_LIST_BY_CORRECT_NUMBER.get(i));
            stringBuilder.append("원)- ");
            stringBuilder.append(correctCountList.get(i));
            stringBuilder.append("개\n");
        }
        double profitRatePercent = getProfitRatePercent();
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append( (long)profitRatePercent);
        stringBuilder.append("%입니다.\n");

        return stringBuilder.toString();
    }
}
