package com.kakao.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class LottoIOTest {

    @Test
    @DisplayName("돈 정보가 없거나 부족하면 null을 반환")
    void buyLottos() {
        assertThat(LottoIO.buyLottos(null))
                .isEqualTo(null);
    }
}