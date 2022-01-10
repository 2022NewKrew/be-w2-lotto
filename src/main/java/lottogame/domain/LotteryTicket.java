package lottogame.domain;

import lottogame.exception.ErrorMessage;
import lottogame.exception.LotteryGameException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryTicket {
    private LotteryNumbers lotteryNumbers;

    public LotteryTicket(LotteryNumbers lotteryNumbers) {
        validateIsNull(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public LotteryTicket(List<Integer> integers) {
        this(new LotteryNumbers(integers.stream().map(LotteryNumber::new).collect(Collectors.toList())));
    }

    private void validateIsNull(LotteryNumbers lotteryNumbers) {
        if (lotteryNumbers == null) {
            throw new LotteryGameException(ErrorMessage.PRAMETER_IS_NULL);
        }
    }

    public LotteryNumbers getLotteryNumbers() {
        return lotteryNumbers;
    }

    public Rank rankTicket(LotteryTicket winningTicket, LotteryNumber bonusNumber) {
        Integer numberOfMatch = lotteryNumbers.countNumberOfMatch(winningTicket.lotteryNumbers);
        boolean bonusMatch = lotteryNumbers.isContain(bonusNumber);
        return Rank.valueOf(numberOfMatch, bonusMatch);
    }

    public boolean isContain(LotteryNumber bonusNumber) {
        return lotteryNumbers.isContain(bonusNumber);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LotteryTicket that = (LotteryTicket) object;
        return Objects.equals(lotteryNumbers, that.lotteryNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumbers);
    }
}
