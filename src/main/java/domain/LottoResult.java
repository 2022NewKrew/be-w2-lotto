package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoResult {
    private final HashMap<LottoRank, Integer> numOfWinnings = new HashMap<>();
    private final ArrayList<Lotto> lottoList;
    private final WinningLotto winningLotto;

    public LottoResult(ArrayList<Lotto> lottoList, WinningLotto winningLotto) {
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
        calcNumOfWinnings();
    }

    private void calcNumOfWinnings() {
        for (Lotto lotto : lottoList) {
            int countOfMatch = getCountOfMatch(lotto.getNumbers());
            boolean matchBonus = isMatchBonus(lotto.getNumbers());
            LottoRank rank = LottoRank.valueOf(countOfMatch, matchBonus);
            numOfWinnings.put(rank, getNumOfRank(rank) + 1);
        }
    }

    private int getCountOfMatch(ArrayList<Integer> numbers) {
        int countOfMatch = 0;
        ArrayList<Integer> winningNumber = winningLotto.getNumbers();
        for (Integer number : numbers) {
            countOfMatch += winningNumber.contains(number) ? 1 : 0;
        }
        return countOfMatch;
    }

    private boolean isMatchBonus(ArrayList<Integer> numbers) {
        return numbers.contains(winningLotto.getBonusNumber());
    }

    private int getNumOfRank(LottoRank rank) {
        return numOfWinnings.getOrDefault(rank, 0);
    }

    public StringBuilder render() {
        StringBuilder builder = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            builder.append(renderResultOfRank(rank));
        }
        return builder;
    }

    private StringBuilder renderResultOfRank(LottoRank rank) {
        StringBuilder rankString = new StringBuilder();
        if (rank == LottoRank.NONE) {
            return rankString;
        }
        rankString.append(rank.getDescription());
        rankString.append(String.format("- %d개", getNumOfRank(rank)));
        rankString.append("\n");
        return rankString;
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
