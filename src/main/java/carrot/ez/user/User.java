package carrot.ez.user;

import carrot.ez.lotto.Lottery;
import carrot.ez.lotto.LotteryGenerator;
import carrot.ez.lotto.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final long amount;
    private final List<Lottery> lotteries = new ArrayList<>();
    private final Map<Rank, Integer> map = new HashMap<>();

    public User(long amount) {
        this.amount = amount;
    }

    public void purchaseLotteries() {
        long cnt = amount / Lottery.LOTTO_PRICE;
        System.out.println(cnt + "개를 구매했습니다.");
        for (int i = 0; i < cnt; i++) {
            Lottery lottery = LotteryGenerator.generateLotto();
            this.lotteries.add(lottery);
        }
    }

    public void printLotteries() {
        for (Lottery lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public void checkWinningLotteries(List<Integer> winNums, int bonus) {
        map.clear(); // 여러 번 호출시 중복 방지
        for (Lottery lottery : lotteries) {
            int numOfCorrect = lottery.getNumOfCorrect(winNums);
            boolean isCorrectBonus = lottery.isCorrectBonus(bonus);
            Rank rank = Rank.of(numOfCorrect, isCorrectBonus);
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
    }

    public void printWiningLotteries() {
        for (Rank state : Rank.values()) {
            printWinningLottery(state);
        }
    }

    private void printWinningLottery(Rank rank) {
        if (rank == Rank.None) {
            return;
        }

        Integer numOfWinningLotteries = map.getOrDefault(rank, 0);
        System.out.println(rank.getCorrectNum() + "개 일치 (" + rank.getPrice() + "원)- " + numOfWinningLotteries + "개");
    }

    private long getEarn() {
        long earn = 0;
        for (Rank rank : Rank.values()) {
            Integer numOfWinningLotteries = map.getOrDefault(rank, 0);
            earn += numOfWinningLotteries * rank.getPrice();
        }
        return earn;
    }

    public void printEarningRate() {
        long earn = getEarn();
        double earningRate = ((double)(earn - amount) / amount) * 100;
        String msg = String.format("총 수익률은 %.0f%%입니다.", earningRate);
        System.out.println(msg);
    }
}
