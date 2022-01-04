package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {
    LottoList lottoList;
    @BeforeEach
    void beforeEach(){
        lottoList = new LottoList();
    }

    @Test
    @DisplayName("금액에 맞는 로또 자동생성 여부")
    void createLottoByPrice(){
        int lottoPrice = 14500;

        lottoList.createAutoLottoList(lottoPrice);

        assertThat(lottoList.getLottoList().size()).isEqualTo(lottoPrice/1000);
    }
}