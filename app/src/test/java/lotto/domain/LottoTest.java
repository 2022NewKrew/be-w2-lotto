package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoTest {

    @DisplayName("Lotto 테스트")
    @Test
    void lottoGenerateTest(){
        Lotto tempLotto = new Lotto(3000);
        assert(tempLotto.getNumberGames() == 3);
    }

    @Test
    void lottoGameWinningTest(){
        LottoGame tempLotto = new LottoGame();
        ArrayList<Integer> tempWinningNumbers= new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        assert(0 <= tempLotto.compareNumbers(tempWinningNumbers) && tempLotto.compareNumbers(tempWinningNumbers) <= 6);
    }

}
