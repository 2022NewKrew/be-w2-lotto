package lottogame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LotteryNumbers {
    private static int DEFAULT_LENGTH = 6;

    private List<LotteryNumber> lotteryNumbers;

    LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
        validateIsNull(lotteryNumbers);
        validateExceedDefaultLength(lotteryNumbers);
        validateIsDuplicate(lotteryNumbers);
        Collections.sort(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validateIsNull(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers == null) {
            throw new IllegalArgumentException("로또번호는 null일 수 없습니다.");
        }
    }

    private void validateExceedDefaultLength(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.size() != DEFAULT_LENGTH) {
            throw new IllegalArgumentException("로또번호는 6개 입니다.");
        }
    }

    private void validateIsDuplicate(List<LotteryNumber> lotteryNumbers) {
        if (lotteryNumbers.stream().distinct().count() != DEFAULT_LENGTH) {
            throw new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
    }

    public int countNumberOfMatch(LotteryNumbers winningNumbers) {
        return (int) winningNumbers.lotteryNumbers.stream()
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
