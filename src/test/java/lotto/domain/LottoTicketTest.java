package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("랜덤으로 로또 티켓 생성")
    @Test
    void create() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }

        LottoTicket lottoTicket = new LottoTicket() {
            @Override
            public LottoNumbers generateLottoNumbers() {
                return LottoNumbers.from(numbers);
            }
        };

        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }
}