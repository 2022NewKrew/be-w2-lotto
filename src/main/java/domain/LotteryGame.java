package domain;

import java.util.*;

public class LotteryGame {
    private static final int PRICE = 1000;

    private final int quantity;
    private int numberOfManual;
    private int numberOfAutomatic;

    private final List<Lottery> lotteries;
    private List<Integer> allNumbers;

    public LotteryGame(int totalPrice) {
        validateTotalPrice(totalPrice);
        setAllNumbers();
        lotteries = new ArrayList<>();
        quantity = totalPrice / PRICE;
    }

    private void validateTotalPrice(int totalPrice) {
        if (totalPrice < PRICE) {
            throw new IllegalArgumentException("Error: 구입금액이 최소 1,000원 이상이어야합니다.");
        }
    }

    private void setAllNumbers() {
        allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
    }

    public void setManualLottery(int numberOfManual) {
        validateNumberOfManual(numberOfManual);
        this.numberOfManual = numberOfManual;
    }

    private void validateNumberOfManual(int numberOfManual) {
        if (numberOfManual > quantity) {
            throw new IllegalArgumentException("Error: 구입금액을 초과하여 구매할 수 없습니다.");
        }
    }

    public void startLotteryGame(List<List<Integer>> manualLotteries) {
        numberOfAutomatic = quantity - numberOfManual;
        for (int i = 0; i < numberOfManual; i++) {
            Lottery lotteryNumber = new Lottery(manualLotteries.get(i));
            lotteries.add(lotteryNumber);
        }
        for (int i = 0; i < numberOfAutomatic; i++) {
            List<Integer> selectedNumbers = selectLotteryNumber();
            Lottery lotteryNumber = new Lottery(selectedNumbers);
            lotteries.add(lotteryNumber);
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

    public Map<Rank, Integer> compareLotteries(WinningLottery winningLottery) {
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

        long profit = ((totalRewards - (long) quantity * PRICE) * 100) / ((long) quantity * PRICE);

        return profit;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNumberOfManual() {
        return numberOfManual;
    }

    public int getNumberOfAutomatic() {
        return numberOfAutomatic;
    }
}
