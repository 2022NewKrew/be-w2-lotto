package lottogame.domain;

import lottogame.exception.ErrorMessage;
import lottogame.exception.LotteryGameException;

import java.util.Objects;

public class LotteryNumber implements Comparable {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int lotteryNumber;

    public LotteryNumber(int lotteryNumber) {
        validateRange(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    private void validateRange(int lotteryNumber) {
        if (lotteryNumber < MIN_NUMBER) {
            throw new LotteryGameException(ErrorMessage.UNDER_MIN_LOTTERY_NUMBER);
        }

        if (lotteryNumber > MAX_NUMBER) {
            throw new LotteryGameException(ErrorMessage.OVER_MAX_LOTTERY_NUMBER);
        }
    }

    @Override
    public int compareTo(Object object) {
        LotteryNumber compare = (LotteryNumber) object;
        return lotteryNumber - compare.lotteryNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LotteryNumber that = (LotteryNumber) object;
        return lotteryNumber == that.lotteryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumber);
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
