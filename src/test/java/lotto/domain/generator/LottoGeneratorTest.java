package lotto.domain.generator;

import lotto.domain.LottoInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void 로또_자동_생성() {
        //given
        LottoGenerator lottoGenerator = new AutoLotto();

        //when
        List<Integer> lottoNums = lottoGenerator.generateNumbers(null);

        //then
        assertEquals(LottoInfo.COUNT_OF_NUMBER.getValue(), lottoNums.size());
        lottoNums.forEach(num -> assertTrue(num >= LottoInfo.MIN_NUMBER.getValue() && num <= LottoInfo.MAX_NUMBER.getValue()));
    }

    @Test
    void 로또_수동_생성() {
        //given
        LottoGenerator lottoGenerator = new ManualLotto();
        List<Integer> inputNums = List.of(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> lottoNums = lottoGenerator.generateNumbers(inputNums);

        //then
        assertArrayEquals(inputNums.toArray(), lottoNums.toArray());
    }
}