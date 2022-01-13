package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoTest {

    @DisplayName("로또 클래스 테스트")
    @Test
    void lottoClassTest(){
        ArrayList<ArrayList<Integer>> manualNumbers = new ArrayList<>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6))));
        Lotto lotto = new Lotto(3000);
        lotto.inputManualNumbers(manualNumbers);
        ArrayList<ArrayList<Integer>> outputLottoGames = lotto.getLottoGames();
        assert(outputLottoGames.get(0).containsAll(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6))));
    }

}
