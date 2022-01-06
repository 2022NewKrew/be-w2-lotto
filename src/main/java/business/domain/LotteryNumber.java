package business.domain;

import java.util.Random;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LotteryNumber implements Comparable<LotteryNumber> {

    private static final int LOTTERY_NUMBER_START = 1;
    private static final int LOTTERY_NUMBER_END = 45;

    private static final Random random = new Random();
    private static final Map<Integer, LotteryNumber> LOTTERY_NUMBER_POOL = new HashMap<>();

    static {
        IntStream.rangeClosed(LOTTERY_NUMBER_START, LOTTERY_NUMBER_END).boxed()
            .forEach((value) -> LOTTERY_NUMBER_POOL.put(value, new LotteryNumber(value)));
    }

    private final int value;

    private LotteryNumber(int value) {
        if (!isValueValid(value)) {
            throw new IllegalArgumentException(
                String.format("%d에서 %d 사이의 숫자만 로또 번호로 사용 가능합니다.", LOTTERY_NUMBER_START,
                    LOTTERY_NUMBER_END));
        }
        this.value = value;
    }

    public static LotteryNumber from(int value) {
        if (!LOTTERY_NUMBER_POOL.containsKey(value)) {
            LOTTERY_NUMBER_POOL.put(value, new LotteryNumber(value));
        }

        return LOTTERY_NUMBER_POOL.get(value);
    }

    public static LotteryNumber random() {
        return LotteryNumber.from(random.nextInt(LOTTERY_NUMBER_END) + 1);
    }

    private boolean isValueValid(int value) {
        return value >= LOTTERY_NUMBER_START && value <= LOTTERY_NUMBER_END;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryNumber that = (LotteryNumber) o;
        return value == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LotteryNumber{" + "value=" + value + '}';
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return Integer.compare(value, o.getValue());
    }
}
