package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class LottoCreatorAutoTest {
    @Test
    @DisplayName("로또 번호 생성")
    void createTicket() {
        // given
        LottoCreater lottoCreater = new LottoCreatorAuto();

        // when
        LottoTicket lottoTicket = lottoCreater.create();

        // then
        Assertions.assertEquals(LottoCreater.NUM_OF_LOTTERY_NUMBERS, lottoTicket.getNumbers().size());
        System.out.println(lottoTicket);
    }

    @DisplayName("로또 번호 중복 X")
    @RepeatedTest(value = 20, name="중복 테스트, {currentRepetition} / {totalRepetitions}")
    void duplicateCheck() {
        // given

        LottoCreater lottoCreater = new LottoCreatorAuto();
        // when
        LottoTicket lottoTicket = lottoCreater.create();

        // then
        Assertions.assertEquals(LottoCreater.NUM_OF_LOTTERY_NUMBERS, new HashSet<>(lottoTicket.getNumbers()).size());
    }
}