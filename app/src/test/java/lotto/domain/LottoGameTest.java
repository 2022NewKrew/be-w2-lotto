package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoGameTest {

    @DisplayName("LottoGames 테스트")
    @Test
    void lottoGenerateTest(){
        LottoGames tempLottoGames = LottoGames.of(3000);
        assert(tempLottoGames.getNumberGames() == 3);
    }

    @Test
    void lottoGameWinningTest(){
        LottoGame tempLotto = LottoGame.of();
        ArrayList<LottoNumber> tempWinningNumbers= new ArrayList<>(Arrays.asList(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6)));
        assert(0 <= tempLotto.compareNumbers(tempWinningNumbers) && tempLotto.compareNumbers(tempWinningNumbers) <= 6);
    }

    @Test
    void lottoGameManualInputTest(){
        LottoGame tempLotto = LottoGame.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assert(tempLotto.getCandidateNumbers().containsAll(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
    }

    @Test
    void lottoGameManualInputNumberTest(){
        LottoGame tempLotto = LottoGame.of();
        ArrayList<LottoNumber> tempWinningNumbers= new ArrayList<>(Arrays.asList(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6)));
        assert(tempLotto.compareNumbers(new ArrayList<>(Arrays.asList(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6)))) == 6);
    }

    @Test
    void lottoGameCompareBonusBallTest(){
        LottoGame tempLotto = LottoGame.of(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assert(tempLotto.compareBonusBall(LottoNumber.of(7)) == false);
    }

}
