package lotto.domain.generator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void 로또_자동_생성() {
        //given
        int countOfAutoLotto = 3;
        LottoGenerator lottoGenerator = new AutoLotto(countOfAutoLotto);

        //when
        List<Lotto> lottoList = lottoGenerator.generateTickets();

        //then
        assertEquals(countOfAutoLotto, lottoList.size());
    }

    @Test
    void 로또_수동_생성() {
        //given
        List<Lotto> lottoInputList = new ArrayList<>();
        lottoInputList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoInputList.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        LottoGenerator lottoGenerator = new ManualLotto(lottoInputList);

        //when
        List<Lotto> lottoList = lottoGenerator.generateTickets();

        //then
        assertArrayEquals(lottoInputList.toArray(), lottoList.toArray());
    }
}