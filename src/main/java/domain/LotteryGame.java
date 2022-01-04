package domain;

import java.util.*;

public class LotteryGame {
    private static final int PRICE = 1000;
    private static final int EMPTY_REWARDS = 0;
    private static final int FOURTH_REWARDS = 5000;
    private static final int THIRD_REWARDS = 50000;
    private static final int SECOND_REWARDS = 1500000;
    private static final int FIRST_REWARDS = 2000000000;
    private static final List<Integer> REWARDS = new ArrayList<>(Arrays.asList(
            EMPTY_REWARDS,
            FIRST_REWARDS,
            SECOND_REWARDS,
            THIRD_REWARDS,
            FOURTH_REWARDS
    ));

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

    public Map<Integer, Result> compareLotteries(List<Integer> winningNumbers) {
        Map<Integer, Result> results = new HashMap<>();

        for (int i = 0; i < REWARDS.size(); ++i) {
            results.put(i, new Result(REWARDS.get(i)));
        }

        for (Lottery lottery : lotteries) {
            int rank = lottery.compareNumbers(winningNumbers);
            results.get(rank).increaseCount();
        }

        setProfit(results);
        return results;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public static int getQuantity() {
        return quantity;
    }

    private void setProfit(Map<Integer, Result> results) {
        long totalRewards = 0;

        for (Integer rank : results.keySet()) {
            Result result = results.get(rank);
            totalRewards += (long) result.getCount() * result.getReward();
        }

        profit = (totalRewards * 100) / ((long) quantity * PRICE);
    }

    public long getProfit() {
        return this.profit;
    }
}

