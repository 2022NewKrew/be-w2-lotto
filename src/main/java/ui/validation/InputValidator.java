package ui.validation;

import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int LOTTERY_NUMBER_START = 1;
    private static final int LOTTERY_NUMBER_END = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private static final long LOTTERY_UNIT_PRICE = 1_000L;

    public void validateLotteryNumber(int value) throws IllegalArgumentException {
        if (value < LOTTERY_NUMBER_START || value > LOTTERY_NUMBER_END) {
            throw new IllegalArgumentException(
                String.format("%d에서 %d 사이의 숫자만 입력 가능합니다.", LOTTERY_NUMBER_START,
                    LOTTERY_NUMBER_END));
        }
    }

    public void validateBudget(long value) throws IllegalArgumentException {
        if (value <= 0 || value % LOTTERY_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(
                String.format("%d원 단위의 양수만 입력 가능합니다.", LOTTERY_UNIT_PRICE));
        }
    }

    public void validateLotteryCount(long value, long limit) throws IllegalArgumentException {
        if (value < 0 || value > limit) {
            throw new IllegalArgumentException(String.format("0에서 %d 사이의 숫자만 입력 가능합니다.", limit));
        }
    }

    public void validateLotteryNumberSet(Set<Integer> lotteryNumberSet)
        throws IllegalArgumentException {
        if (lotteryNumberSet.size() != LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                String.format("서로 다른 %d개의 숫자만 입력 가능합니다.", LOTTERY_NUMBER_COUNT));
        }

        lotteryNumberSet.forEach(this::validateLotteryNumber);
    }

    public void validateLotteryNumberSetList(List<Set<Integer>> lotteryNumberSetList)
        throws IllegalArgumentException {
        lotteryNumberSetList.forEach(this::validateLotteryNumberSet);
    }
}
