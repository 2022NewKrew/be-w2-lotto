package constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("match와 bonus 여부로 Rank 잘 찾는지")
    @Test
    void valueOf() {
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));

        assertEquals(null, Rank.valueOf(2, false));
        assertEquals(null, Rank.valueOf(2, true));
        assertEquals(null, Rank.valueOf(1, false));
        assertEquals(null, Rank.valueOf(1, true));
    }
}
