package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void getNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6).stream().collect(Collectors.toList()));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), lotto.getNumbers().get());
    }
}