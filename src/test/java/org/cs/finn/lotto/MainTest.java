package org.cs.finn.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    @DisplayName("2 + 3은 5다")
    public void testAddOp() {
        // then
        assertThat(2 + 3).isEqualTo(5);
    }
}
