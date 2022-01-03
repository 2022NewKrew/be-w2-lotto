package carrot.ez.user;

import carrot.ez.lotto.Lottery;
import carrot.ez.lotto.LotteryGenerator;
import carrot.ez.lotto.WiningInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final long amount;
    private final List<Lottery> lotteries = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

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

    public void checkWinningLotteries(List<Integer> winNums) {
        map.clear(); // 여러 번 호출시 중복 방지
        for (Lottery lottery : lotteries) {
            int numOfCorrect = lottery.getNumOfCorrect(winNums);
            map.put(numOfCorrect, map.getOrDefault(numOfCorrect, 0) + 1);
        }
    }

    public void printWiningLotteries() {
        for (WiningInfo state : WiningInfo.values()) {
            printWinningLottery(state);
        }
    }

    private void printWinningLottery(WiningInfo state) {
        Integer numOfWinningLotteries = map.getOrDefault(state.getCorrectNum(), 0);
        System.out.println(state.getCorrectNum() + "개 일치 (" + state.getPrice() + "원)- " + numOfWinningLotteries + "개");
    }

    private long getEarn() {
        long earn = 0;
        for (WiningInfo state : WiningInfo.values()) {
            Integer numOfWinningLotteries = map.getOrDefault(state.getCorrectNum(), 0);
            earn += numOfWinningLotteries * state.getPrice();
        }
        return earn;
    }

    public void printEarningRate() {
        long earn = getEarn();
        double earningRate = ((double)earn / amount) * 100;
        String msg = String.format("총 수익률은 %.0f%%입니다.", earningRate);
        System.out.println(msg);
    }
}
