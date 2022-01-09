package lotto.domain.winningstats.lottobundle.lottoticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllLottoNumberListTest {

    @Test
    void createAutoLottoTicket() {
        assertEquals(AllLottoNumberList.createAutoLottoTicket().size(),6);
    }
}