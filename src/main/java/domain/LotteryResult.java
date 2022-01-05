package domain;

import java.util.List;

public class LotteryResult {
    private static final LotteryNumbersFactory LOTTERY_NUMBERS_FACTORY = new LotteryNumbersFactory();
    private final List<Integer> numbers;
    private final int bonusBall;

    public LotteryResult(List<Integer> numbers, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼 " + bonusBall + "은 당첨 번호 " + numbers + "에 포함되면 안 됩니다.");
        }

        // bonusBall의 값 범위 검증 추가해야 됨
        this.numbers = LOTTERY_NUMBERS_FACTORY.getValidatedNumbers(numbers);
        this.bonusBall = bonusBall;
    }

    public int getMatchingCountOf(LotteryTicket lotteryTicket) {
        return (int) numbers.stream().filter(number -> lotteryTicket.contains(number)).count();
    }

    public boolean isBonusBallMatched(LotteryTicket lotteryTicket) {
        return lotteryTicket.contains(this.bonusBall);
    }
}
