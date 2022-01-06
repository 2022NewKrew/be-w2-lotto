package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    Lotto lotto;
    @BeforeEach
    void setUp() {
        lotto = new DefaultLotto();
    }

    @Test
    @DisplayName("겹치는 숫자 개수세기")
    void calculateEqualCount() {
        lotto.initialize("1, 2, 3, 4, 5, 6");
        Lotto anotherLotto = new DefaultLotto();
        anotherLotto.initialize("4, 5, 6, 7, 8, 9");
        assertThat(Lotto.calculateEqualCount(lotto, anotherLotto)).isEqualTo(3);
    }
}