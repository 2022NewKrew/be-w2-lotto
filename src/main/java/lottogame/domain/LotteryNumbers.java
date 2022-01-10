package lottogame.domain;

import lottogame.exception.ErrorMessage;
import lottogame.exception.LotteryGameException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LotteryNumbers {
    private static int DEFAULT_LENGTH = 6;

    private final List<LotteryNumber> lotteryNumbers;

    public LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        validateIsNull(lotteryNumbers);
        validateExceedDefaultLength(lotteryNumbers);
        validateIsDuplicate(lotteryNumbers);
        Collections.sort(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validateIsNull(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers == null) {
            throw new LotteryGameException(ErrorMessage.PRAMETER_IS_NULL);
        }
    }

    private void validateExceedDefaultLength(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != DEFAULT_LENGTH) {
            throw new LotteryGameException(ErrorMessage.NOT_MATCH_LOTTERY_NUMBERS_DEFAULT_LENGTH);
        }
    }

    private void validateIsDuplicate(List<LotteryNumber> lotteryNumbers) {
        int distinctLength = (int) lotteryNumbers.stream().distinct().count();
        if (distinctLength != DEFAULT_LENGTH) {
            throw new LotteryGameException(ErrorMessage.DUPLICATE_LOTTERY_NUMBERS);
        }
    }

    public int countNumberOfMatch(LotteryNumbers winningNumbers) {
        return (int) winningNumbers.lotteryNumbers
                .stream()
                .filter(winningNumber -> isContain(winningNumber))
                .count();
    }

    public boolean isContain(LotteryNumber lotteryNumber) {
        return lotteryNumbers.contains(lotteryNumber);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LotteryNumbers that = (LotteryNumbers) object;
        return Objects.equals(lotteryNumbers, that.lotteryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumbers);
    }

    public List<LotteryNumber> getLotteryNumbers() {
        return lotteryNumbers;
    }
}
