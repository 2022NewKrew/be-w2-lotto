package bin.jaden.be_w2_lotto.LottoGame;

import bin.jaden.be_w2_lotto.data.Constants;
import bin.jaden.be_w2_lotto.exception.InvalidArraySizeException;
import bin.jaden.be_w2_lotto.exception.NumberOutOfRangeException;
import bin.jaden.be_w2_lotto.lottoGame.ManualLottoGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManualLottoGameTest {

    @Test
    public void wrongNumberFormatTest() {
        String input = "1, 2, 3, wrong, 5, 6";

        final NumberFormatException exception = assertThrows(NumberFormatException.class, () -> new ManualLottoGame(input));

        assertThat(exception.getMessage()).isEqualTo("For input string: \"wrong\"");
    }

    @Test
    public void wrongNumbersSizeTest() {
        String input = "1, 2, 3, 4, 5, 6, 7";

        final InvalidArraySizeException exception = assertThrows(InvalidArraySizeException.class, () -> new ManualLottoGame(input));

        assertThat(exception.getMessage()).isEqualTo(Constants.INVALID_MANUAL_NUMBERS_LENGTH_MESSAGE);
    }

    @Test
    public void exceedNumberRangeTest() {
        String input = "1, 2, 3, 4, 5, 202201";

        final NumberOutOfRangeException exception = assertThrows(NumberOutOfRangeException.class, () -> new ManualLottoGame(input));

        assertThat(exception.getMessage()).isEqualTo(Constants.INVALID_MANUAL_NUMBERS_RANGE_MESSAGE);
    }

    @Test
    public void manualLottoGameTest() {
        String input = "1, 2, 3, 4, 5, 6";

        assertDoesNotThrow(() -> new ManualLottoGame(input));
    }
}