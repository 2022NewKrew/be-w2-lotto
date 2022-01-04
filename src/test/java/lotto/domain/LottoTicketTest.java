package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    void create() {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(LottoNumber.from(i));
        }
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("랜덤 로또 티켓 생성 테스트")
    @Test
    void issue() {
        LottoNumbersGenerator lottoNumbersGenerator = new RandomLottoNumberGenerator();

        LottoTicket lottoTicket = LottoTicket.issue(lottoNumbersGenerator);
        LottoNumbers lottoNumbers = lottoTicket.getLottoNumbers();

        assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
    }
}