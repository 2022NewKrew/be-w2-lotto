package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RankTest {

    @Test
    void valueOf_ValidParameter_ReturnsAppropriateRank() {
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(3,true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void valueOf_InvalidParameter_ThrowsIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.valueOf(-1, true))
                        .withMessage("당첨 정보가 올바르지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.valueOf(7, true))
                .withMessage("당첨 정보가 올바르지 않습니다.");
    }
}
