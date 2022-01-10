package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {

    @DisplayName("금액에 맞는 개수의 로또 티켓 발급 테스트")
    @ParameterizedTest
    @CsvSource({"10, 2", "100, 10", "10000, 10000"})
    void issue(int autoCount, int manualCount) {
        LottoTicketCount autoTicketCount = new LottoTicketCount(autoCount);
        LottoTicketCount manualTicketCount = new LottoTicketCount(manualCount);
        String[] strings = {"1", "2", "3", "4", "5", "6"};
        List<String[]> manualLottoNumbers = IntStream.range(0, manualCount)
                .mapToObj(i -> strings)
                .collect(Collectors.toList());

        LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator(), new ManualLottoNumberGenerator());
        LottoTickets lottoTickets = lottoMachine.issue(autoTicketCount, manualTicketCount, manualLottoNumbers);

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(autoCount + manualCount);
    }
}