package domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameServiceTest {

    @Test
    void test() {
        LottoWinningType lottoWinningType = LottoWinningType.FIRST;
        System.out.println(LottoWinningType.values());
    }

}

enum LottoWinningType {

    FIRST(6, 2000000000),
    SECOND(5, 150000000);

    private int numOfMatching;

    private int winnings;

    LottoWinningType(int numOfMatching, int winnings) {
        this.numOfMatching = numOfMatching;
        this.winnings = winnings;
    }

    public int getNumOfMatching() {
        return numOfMatching;
    }

    public int getWinnings() {
        return winnings;
    }
}