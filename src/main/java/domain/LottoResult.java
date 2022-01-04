package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoResult {
    private final HashMap<LottoRank, Integer> results = new HashMap<>();
    private final ArrayList<Lotto> lottoList;
    private final ArrayList<Integer> winningNumber;
    private final int bonusNumber;

    public LottoResult(ArrayList<Lotto> lottoList, ArrayList<Integer> winningNumber, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        calcResult();
    }

    private void calcResult() {
        for (Lotto lotto : lottoList) {
            int countOfMatch = getCountOfMatch(lotto.getNumbers());
            boolean matchBonus = isMatchBonus(lotto.getNumbers());
            LottoRank rank = LottoRank.valueOf(countOfMatch, matchBonus);
            results.put(rank, getNumOfRank(rank) + 1);
        }
    }

    private int getCountOfMatch(ArrayList<Integer> numbers) {
        int countOfMatch = 0;
        for (Integer number : numbers) {
            countOfMatch += winningNumber.contains(number) ? 1 : 0;
        }
        return countOfMatch;
    }

    private boolean isMatchBonus(ArrayList<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private int getNumOfRank(LottoRank rank) {
        if (results.containsKey(rank)) {
            return results.get(rank);
        }
        return 0;
    }

    public StringBuilder render() {
        StringBuilder builder = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            builder.append(rank.getDescription());
            builder.append(String.format("- %d개", getNumOfRank(rank)));
            builder.append("\n");
        }
        return builder;
    }

    public float getYieldByPercent(int price) {
        int purchaseMoney = lottoList.size() * price;
        if (purchaseMoney == 0) {
            return 0.0f;
        }
        long winningMoney = getTotalWinningMoney();
        return 100.0f * (winningMoney - purchaseMoney) / purchaseMoney;
    }

    public long getTotalWinningMoney() {
        long totalWinningMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalWinningMoney += getNumOfRank(rank) * rank.getWinningMoney();
        }
        return totalWinningMoney;
    }
}
