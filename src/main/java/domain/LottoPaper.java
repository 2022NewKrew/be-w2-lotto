package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPaper {
    private static final int LOTTO_PRICE = 1000;
    private final ArrayList<Lotto> paper = new ArrayList<>();
    private final HashMap<Rank, Integer> rankToCnt = new HashMap<>();
    private static final HashMap<Integer, Rank> cntToRank = new HashMap<>();

    public LottoPaper(long money) {
        int buyMax = (int) money / LOTTO_PRICE;
        IntStream.range(0, buyMax)
                .forEach(buy -> paper.add(new Lotto()));

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.SECOND)
                .forEach(rank -> cntToRank.put(rank.getCountOfMatch(), rank));
    }

    @Override
    public String toString() {
        return paper.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("]\n[", "[", "]"));
    }

    public int countLotto() {
        return paper.size();
    }

    public HashMap<Rank, Integer> winningResult(Lotto winningNum, int bonusNum) {
        Arrays.stream(Rank.values()).forEach(rank -> rankToCnt.put(rank, 0));
        Rank rank;
        for (Lotto lotto : paper) {
            rank = cntToRank.get(lotto.sameWithWinningNum(winningNum));
            if (rank != null) {
                rankToCnt.put(rank, rankToCnt.get(rank) + 1);
            }
        }
        bonusCheck(winningNum, bonusNum);

        return rankToCnt;
    }

    private void bonusCheck(Lotto winningNum, int bonusNum) {
        int sameBonus = (int) paper.stream()
                .filter(lotto -> lotto.sameWithWinningNum(winningNum) == 5)
                .filter(lotto -> lotto.containBonusNum(bonusNum))
                .count();
        rankToCnt.put(Rank.SECOND, rankToCnt.get(Rank.SECOND) + sameBonus);
        rankToCnt.put(Rank.THIRD, rankToCnt.get(Rank.THIRD) - sameBonus);
    }

    public int winRate() {
        long useCost = (long) paper.size() * LOTTO_PRICE;
        long winCost = Arrays.stream(Rank.values())
                .mapToLong(rank -> rankToCnt.get(rank) * rank.getWinningMoney())
                .sum();
        return (int) (winCost * 100 / useCost);
    }
}
