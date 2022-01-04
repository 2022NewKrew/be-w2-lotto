package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (0) : 0개 일치")
    void correctTest0() {
        List<Integer> myNumbers = List.of(8, 9, 10, 11, 12, 13);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 0);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (1) : 1개 일치")
    void correctTest1() {
        List<Integer> myNumbers = List.of(1, 9, 10, 11, 12, 13);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 1);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (2) : 2개 일치")
    void correctTest2() {
        List<Integer> myNumbers = List.of(1, 2, 10, 11, 12, 13);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 2);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (3) : 3개 일치")
    void correctTest3() {
        List<Integer> myNumbers = List.of(1, 2, 3, 11, 12, 13);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 3);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (4) : 4개 일치")
    void correctTest4() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 12, 13);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 4);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (5) : 5개 일치")
    void correctTest5() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 13);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 5);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (6) : 5개 일치, 보너스 번호 일치")
    void correctTest6() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 6);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (7) : 6개 일치")
    void correctTest7() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(myNumbers);
        LottoGame lottoGame = new LottoGame(List.of(lotto), answer, bonusNumber);

        assertEquals(lotto.getResult(lottoGame), 7);
    }

    @RepeatedTest(10000)
    @DisplayName("랜덤으로 로또번호를 생성하고 " +
                 "그 번호들이 서로 겹치지 않는지," +
                 "1~45 사이인지," +
                 "6개인지 10000번 테스트")
    void createRandomLottoNumber() {
        Lotto.createRandomLotto();
    }
}