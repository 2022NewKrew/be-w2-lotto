package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPaper {
    private static final int LOTTO_PRICE = 1000;
    private static final int WINNING_PRICE_1st = 2000000000;
    private static final int WINNING_PRICE_2nd = 1500000;
    private static final int WINNING_PRICE_3rd = 50000;
    private static final int WINNING_PRICE_4th = 5000;
    private final ArrayList<Lotto> paper = new ArrayList<>();
    private final HashMap<Integer, Integer> sameToCnt = new HashMap<>();

    public LottoPaper(long money) {
        int buyMax = (int)money / LOTTO_PRICE;
        for(int buy=0; buy<buyMax; buy++){
            paper.add(new Lotto());
        }
    }

    @Override
    public String toString(){
        return paper.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("]\n[", "[", "]"));
    }

    public int countLotto(){
        return paper.size();
    }

    public HashMap<Integer, Integer> winningResult(List<Integer> winningNum){
        int sameNum;
        IntStream.range(0,7).forEach(num -> sameToCnt.put(num,0));
        for(Lotto lotto : paper){
            sameNum = lotto.sameWithWinningNum(winningNum);
            sameToCnt.put(sameNum, sameToCnt.get(sameNum)+1);
        }
        return sameToCnt;
    }

    public int winRate(){
        long useCost = (long) paper.size() * LOTTO_PRICE;
        long winCost = 0;
        winCost += sameToCnt.get(3) * WINNING_PRICE_4th;
        winCost += sameToCnt.get(4) * WINNING_PRICE_3rd;
        winCost += sameToCnt.get(5) * WINNING_PRICE_2nd;
        winCost += sameToCnt.get(6) * WINNING_PRICE_1st;
        return (int) (winCost * 100 / useCost);
    }
}
