package business.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

public class RanksTest {

    @ParameterizedTest
    @NullSource
    void constructor_NullParameter_ThrowsIllegalArgumentException(List<Rank> parameter) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ranks(parameter));
    }

    @ParameterizedTest
    @EmptySource
    void constructor_EmptyParameter_DoesNotThrowIllegalArgumentsException(List<Rank> parameter) {
        assertThatNoException().isThrownBy(() -> new Ranks(parameter));
    }

    @Test
    void constructor_ValidParameter_DoesNotThrowIllegalArgumentsException() {
        assertThatNoException().isThrownBy(() -> new Ranks(List.of(Rank.values())));
    }

    @ParameterizedTest
    @MethodSource("provideRankAndCount")
    void getCountOf_Invoked_ReturnsCorrectValue(Rank rank, int expected) {
        Ranks given = new Ranks(
            List.of(Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FOURTH,
                Rank.FOURTH, Rank.FIFTH));

        assertThat(given.getCountOf(rank)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRankAndCount() {
        return Stream.of(Arguments.of(Rank.FIRST, 1), Arguments.of(Rank.SECOND, 2),
            Arguments.of(Rank.THIRD, 1), Arguments.of(Rank.FOURTH, 3), Arguments.of(Rank.FIFTH, 1),
            Arguments.of(Rank.MISS, 0));
    }
}
