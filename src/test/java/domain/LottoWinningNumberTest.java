package domain;
import exception.InvalidLottoLengthException;
import exception.InvalidLottoNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumberTest {

    @Test
    @DisplayName("보너스 볼 포함 여부")
    void invalidLottoBonusException() {
        // given
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        InvalidLottoNumberException thrown = Assertions.assertThrows(InvalidLottoNumberException.class, () -> {
            new LottoWinningNumber(numbers, 6);
        });

        // then
        Assertions.assertEquals("Bonus ball should not in Lotto", thrown.getMessage());
    }
}