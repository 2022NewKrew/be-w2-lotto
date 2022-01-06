package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RandomLottoTicketTest {

    @DisplayName("랜덤으로 생성된 로또 티켓은 로또 넘버 45개 중 6개를 가지고 있어야 한다.")
    @Test
    void construct() {
        RandomLottoTicket ticket = new RandomLottoTicket();
        int count = (int) IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .mapToObj(LottoNumber::new)
                .filter(ticket::containLottoNumber)
                .count();
        assertThat(count).isEqualTo(LottoNumbers.SIZE_OF_LOTTO_NUMBERS);
    }
}