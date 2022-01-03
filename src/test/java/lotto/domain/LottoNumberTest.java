package lotto.domain;

import lotto.util.RandomNumberCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (1)")
    void correctTest1() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(myNumbers);
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(lottoNumber.getResult(answer), 6);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (2)")
    void correctTest2() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(myNumbers);
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 7);

        assertEquals(lottoNumber.getResult(answer), 5);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (3)")
    void correctTest3() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(myNumbers);
        List<Integer> answer = List.of(7, 8, 9, 10, 11, 12);

        assertEquals(lottoNumber.getResult(answer), 0);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (4)")
    void correctTest4() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(myNumbers);
        List<Integer> answer = List.of(1, 2, 5, 6, 10, 12);

        assertEquals(lottoNumber.getResult(answer), 4);
    }

    @Test
    @DisplayName("생성한 로또번호와, 당첨번호를 비교했을 때 일치하는 번호의 수가 잘 나오는지 테스트 (5)")
    void correctTest5() {
        List<Integer> myNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(myNumbers);
        List<Integer> answer = List.of(6, 7, 8, 9, 10, 11);

        assertEquals(lottoNumber.getResult(answer), 1);
    }

    @RepeatedTest(10000)
    @DisplayName("랜덤으로 로또번호를 생성하고 " +
                 "그 번호들이 서로 겹치지 않는지," +
                 "1~45 사이인지," +
                 "6개인지 10000번 테스트")
    void createRandomLottoNumber() {
        List<Integer> numbers = RandomNumberCreator.createRandomNumbers();
        new LottoNumber(numbers);
    }
}