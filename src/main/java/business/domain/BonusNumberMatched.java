package business.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BonusNumberMatched {

    private static final Map<Boolean, BonusNumberMatched> BONUS_NUMBER_MATCHED_POOL = new HashMap<>();

    static {
        BONUS_NUMBER_MATCHED_POOL.put(true, new BonusNumberMatched(true));
        BONUS_NUMBER_MATCHED_POOL.put(false, new BonusNumberMatched(false));
    }

    private final boolean value;

    private BonusNumberMatched(boolean value) {
        this.value = value;
    }

    public static BonusNumberMatched from(boolean value) {
        return BONUS_NUMBER_MATCHED_POOL.get(value);
    }

    public boolean getValue() {
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
        BonusNumberMatched that = (BonusNumberMatched) o;
        return value == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "BonusBallMatched{" + "value=" + value + '}';
    }
}
