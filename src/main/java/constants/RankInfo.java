package constants;

import java.util.Arrays;
import java.util.stream.Stream;

public enum RankInfo {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),

    FAIL(2, 0);


    private final int count;
    private final int reward;

    RankInfo(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getCount() {
        return count;
    }

    public static RankInfo valueOf(int count, boolean bonus) {
        if (count == SECOND.count) {
            return bonus ? SECOND : THIRD;
        }
        return valuesStream()
                .filter(rankInfo -> rankInfo.count == count)
                .findAny()
                .orElse(FAIL);
    }

    public String getViewFormat(int matched) {
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append("개 일치");
        if (this == SECOND) sb.append(", 보너스 볼 일치");
        sb.append("(");
        sb.append(reward);
        sb.append(")- ");
        sb.append(matched);
        sb.append("개");
        return sb.toString();
    }

    public static Stream<RankInfo> valuesStream() {
        return Arrays.stream(values())
                .filter(rankInfo -> rankInfo.count > 2);
    }

    public long getEarned(int matched) {
        return (long) reward * matched;
    }
}
