package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@DisplayName("랜덤 번호 생성기 테스트")
class RandomNumbersTest {

    @Test
    @DisplayName("랜덤으로 6개 번호를 만들 수 있어야 한다.")
    void getRandomLottoNumbers() {
        ArrayList<Integer> randomNumbers =  RandomNumbers.getRandomLottoNumbers();

        assertThat(randomNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("랜덤으로 만든 번호의 순서는 오름차순이어야 한다.")
    void getRandomLottoNumbersIncrease() {
        ArrayList<Integer> randomNumbers =  RandomNumbers.getRandomLottoNumbers();

        for (int i = 1; i < randomNumbers.size(); i++) {
            assertThat(randomNumbers.get(i - 1) < randomNumbers.get(i)).isEqualTo(true);
        }
    }
}