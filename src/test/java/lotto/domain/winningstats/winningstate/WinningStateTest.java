package lotto.domain.winningstats.winningstate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningStateTest {

    int lottoCorrectCnt = 4;

    WinningState winningState = new WinningState(lottoCorrectCnt, true);

    @Test
    void testEquals() {

        assertEquals(winningState, new WinningState(lottoCorrectCnt));

        WinningState winningState1 = new WinningState(lottoCorrectCnt, false);

        assertEquals(winningState1, new WinningState(lottoCorrectCnt));

    }

    @Test
    void testHashCode() {
        assertEquals(winningState.hashCode(), lottoCorrectCnt);
    }
}