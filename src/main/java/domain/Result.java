package domain;

import enums.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final LottoRepository lottoRepository;
    private final List<Integer> winningNums;
    private final int bonusBall;
    private final int quantity;
    private final Map<Rank, Integer> prizeList = new EnumMap<>(Rank.class);

    public Result(LottoRepository lottoRepository, List<Integer> winningNums, int bonusBall) {
        this.lottoRepository = lottoRepository;
        this.winningNums = winningNums;
        this.quantity = lottoRepository.getList().size();
        this.bonusBall = bonusBall;
        enumMapInit();
        setPrizeList();
    }

    private void enumMapInit() {
        prizeList.put(Rank.FIFTH, 0);
        prizeList.put(Rank.FOURTH, 0);
        prizeList.put(Rank.THIRD, 0);
        prizeList.put(Rank.SECOND, 0);
        prizeList.put(Rank.FIRST, 0);
        prizeList.put(Rank.NOMATCH, 0);
    }


    private void setPrizeList() {
        for (List<Integer> lotto : lottoRepository.getList()) {
            Rank rank = Rank.valueOf(bonusMatch(lotto, bonusBall), numberMatch(lotto));
            int size = prizeList.get(rank);
            prizeList.put(rank, size + 1);
        }
    }

    public Map<Rank, Integer> getPrizeList() {
        return prizeList;
    }

    private int numberMatch(List<Integer> lotto) {
        lotto.retainAll(winningNums);
        return lotto.size();
    }

    private boolean bonusMatch(List<Integer> lotto, int bonusBall) {
        return lotto.contains(bonusBall);
    }

    public double calculateYield() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : prizeList.entrySet()) {
            totalPrize += (long) entry.getKey().getWinningMoney() * entry.getValue();
        }
        long totalSpent = (long) quantity * 1000;
        return (double) totalPrize / (double) totalSpent * 100 - 100;
    }

}
