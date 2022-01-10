package domain;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualLottoTicketGeneratorTest {

    @Test
    @DisplayName("[성공] LottoNumber 객체를 생성한다")
    void generate() {
        ManualLottoTicketGenerator manualLottoTicketGenerator = new ManualLottoTicketGenerator();
        Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = lottoTicket(1, 2, 3, 4, 5, 6);

        Assertions.assertEquals(lottoTicket, manualLottoTicketGenerator.generate(lottoNumbers));
    }

    @Test
    @DisplayName("[실패] null이 들어올 시 InvalidLottoNumber 예외를 던진다")
    void generate_Failed_By_Null() {
        ManualLottoTicketGenerator manualLottoTicketGenerator = new ManualLottoTicketGenerator();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> manualLottoTicketGenerator.generate(null));
    }

    LottoTicket lottoTicket(int n1, int n2, int n3, int n4, int n5, int n6) {
        Set<LottoNumber> numbers = Set.of(LottoNumber.from(n1), LottoNumber.from(n2), LottoNumber.from(n3),
                LottoNumber.from(n4), LottoNumber.from(n5), LottoNumber.from(n6));

        return new LottoTicket(numbers);
    }
}