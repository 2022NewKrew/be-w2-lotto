package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {
    LottoMachine lottoMachine;
    @BeforeEach
    void beforeEach(){
        lottoMachine = new LottoMachine();
    }

    @Test
    @DisplayName("금액에 맞는 로또 자동생성 여부")
    void createLottoByPrice(){
        int lottoPrice = 14500;

        lottoMachine.autoLottoList(lottoPrice);

        assertThat(lottoMachine.getLottoList().getCount()).isEqualTo(lottoPrice/1000);
    }
}