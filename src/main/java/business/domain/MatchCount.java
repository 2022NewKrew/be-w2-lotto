package business.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class MatchCount {

    public static final int MATCH_COUNT_MIN = 0;
    public static final int MATCH_COUNT_MAX = 6;

    private static final Map<Integer, MatchCount> MATCH_COUNT_POOL = new HashMap<>();

    static {
        IntStream.rangeClosed(MATCH_COUNT_MIN, MATCH_COUNT_MAX).boxed()
            .forEach((value) -> MATCH_COUNT_POOL.put(value, new MatchCount(value)));
    }

    private final int value;

    private MatchCount(int value) {
        if (!isValueValid(value)) {
            throw new IllegalArgumentException(
                String.format("로또 번호 일치 개수는 %d에서 %d 사이의 값만 사용 가능합니다.", MATCH_COUNT_MIN,
                    MATCH_COUNT_MAX));
        }
        this.value = value;
    }

    public static MatchCount from(int value) {
        if (!MATCH_COUNT_POOL.containsKey(value)) {
            MATCH_COUNT_POOL.put(value, new MatchCount(value));
        }

        return MATCH_COUNT_POOL.get(value);
    }

    public int getValue() {
        return value;
    }

    private boolean isValueValid(int value) {
        return value >= MATCH_COUNT_MIN && value <= MATCH_COUNT_MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchCount that = (MatchCount) o;
        return value == that.getValue();
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
