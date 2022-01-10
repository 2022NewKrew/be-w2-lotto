package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoTicketGeneratorTest {

    @Test
    @DisplayName("[성공] 랜덤 로또를 생성한다")
    void generate() {
        RandomLottoTicketGenerator randomLottoTicketGenerator = new RandomLottoTicketGenerator();
        int numberOfLotteryNumbers = 6;

        LottoTicket lottoTicket = randomLottoTicketGenerator.generate(null);

        Assertions.assertEquals(lottoTicket.numbers().size(), numberOfLotteryNumbers);
    }
}