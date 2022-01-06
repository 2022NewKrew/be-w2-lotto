package domain;

import controller.BuyLotto;
import view.LottoOutput;

import java.util.Map;
import java.util.TreeMap;

public class WinningStats {
    private final Map<Ranking, Integer> prizeMap = new TreeMap<>();
    private final int winningPrize;
    public WinningStats(int winningPrize){
        this.winningPrize = winningPrize;
    }
    public void addStats(Ranking ranking, int num){
        if(ranking!=Ranking.NONE){
            prizeMap.put(ranking,num);
        }
    }
    public void printMap(){
        prizeMap.forEach((ranking, count) -> System.out.printf((LottoOutput.PRIZE_STR_FORMAT) + "%n",ranking.getMatchCount(),ranking.getWiningPrize(),count));
    }
    public double getTotalIncome(){
        return ((double)(winningPrize - BuyLotto.buyPrice)) * 100 / BuyLotto.buyPrice;
    }
}
