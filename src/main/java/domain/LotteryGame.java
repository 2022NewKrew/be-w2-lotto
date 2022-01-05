package domain;

import java.util.*;

public class LotteryGame {
    private static final int PRICE = 1000;

    private static int quantity;

    private List<Integer> allNumbers;
    private final List<Lottery> lotteries;

    private long profit = 0;

    public LotteryGame(int totalPrice) {
        setAllNumbers();
        lotteries = new ArrayList<>();
        quantity = totalPrice / PRICE;
        for (int i = 0; i < quantity; i++) {
            List<Integer> selectedNumbers = selectLotteryNumber();
            Lottery lotteryNumber = new Lottery(selectedNumbers);
            lotteries.add(lotteryNumber);
        }
    }

    private void setAllNumbers() {
        allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
    }

    private List<Integer> selectLotteryNumber() {
        Collections.shuffle(allNumbers);
        List<Integer> selectedNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            selectedNumbers.add(allNumbers.get(i));
        }
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

    public Map<Rank, Integer> compareLotteries(List<Integer> winningNumbers, int bonusNumber) {
        WinningLottery winningLottery = new WinningLottery(winningNumbers, bonusNumber);
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
        for (Lottery lottery : lotteries) {
            Rank rank = lottery.compareNumbers(winningLottery);
            results.put(rank, results.get(rank) + 1);
        }
        return results;
    }

    public long getProfit(Map<Rank, Integer> results) {
        long totalRewards = 0;

        for (Rank rank : results.keySet()) {
            int count = results.get(rank);
            totalRewards += (long) count * rank.getWinningMoney();
        }

        profit = ((totalRewards - (long) quantity * PRICE) * 100) / ((long) quantity * PRICE);

        return profit;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public static int getQuantity() {
        return quantity;
    }
}
