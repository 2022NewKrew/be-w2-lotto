package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void testSmallLottoSizeThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<Integer> size5Numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
            new Lotto(size5Numbers);
        });
    }

    @Test
    void testLargeLottoSizeThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<Integer> size7Numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
            new Lotto(size7Numbers);
        });
    }

    @Test
    void testUnderMinRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<Integer> under1Numbers = new ArrayList<>(Arrays.asList(0,1,2,3,4,5));
            new Lotto(under1Numbers);
        });
    }

    @Test
    void testOverMaxRangeThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayList<Integer> over45Numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,46));
            new Lotto(over45Numbers);
        });
    }
}
