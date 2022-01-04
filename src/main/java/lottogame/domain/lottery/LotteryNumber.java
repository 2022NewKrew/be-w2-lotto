package lottogame.domain.lottery;

public class LotteryNumber {
    private static final int MIN_LOTTERY_NUMBER = 1;
    private static final int MAX_LOTTERY_NUMBER = 45;

    private int lotteryNumber;

    LotteryNumber(int lotteryNumber) {
        validateRange(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    private void validateRange(int lotteryNumber) {
        if (lotteryNumber > MAX_LOTTERY_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 45 이하만 가능합니다.");
        }

        if (lotteryNumber < MIN_LOTTERY_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 이상만 가능합니다.");
        }
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(lotteryNumber);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LotteryNumber) {
            return this.lotteryNumber == ((LotteryNumber) object).getLotteryNumber();
        }
        return false;
    }
}