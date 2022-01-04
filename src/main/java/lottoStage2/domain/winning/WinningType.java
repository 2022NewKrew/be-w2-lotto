package lottoStage2.domain.winning;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningType {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_00),
    SECOND(5, true, 30_000_000),
    FIRST(6, true, 2_000_000_000);

    private static final Map<Discrimination, String> MATCH_COUNT_MAP =
            Collections.unmodifiableMap(
                    Stream.of(values()).collect(Collectors.toMap(WinningType::getDiscrimination, WinningType::name)));


    private final Discrimination discrimination;
    private final int winnings;

    WinningType(int matchCount, boolean matchBonus, int winnings) {
        discrimination = new Discrimination(matchCount, matchBonus);
        this.winnings = winnings;
    }

    public static WinningType of(int matchCount) {
        return WinningType.valueOf(MATCH_COUNT_MAP.get(matchCount));
    }

    public Discrimination getDiscrimination() {
        return discrimination;
    }

    public int getWinnings() {
        return winnings;
    }

    static class Discrimination {
        private final int matchCount;
        private final boolean matchBonus;

        Discrimination(int matchCount, boolean matchBonus) {
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Discrimination that = (Discrimination) o;
            return matchCount == that.matchCount && matchBonus == that.matchBonus;
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchCount, matchBonus);
        }
    }
}
