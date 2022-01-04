package lottoStage2.domain.vo;

import java.util.Objects;

public class Discrimination {
    private final int matchCount;
    private final boolean matchBonus;

    public Discrimination(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
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
