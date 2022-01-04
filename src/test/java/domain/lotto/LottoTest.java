package domain.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    Lotto lotto;

    @BeforeEach
    void init() {
        List<Number> numbers = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            numbers.add(new Number(i));
        }
        lotto = new Lotto(numbers); //1,2,3,4,5,6
    }

    @Test
    @DisplayName("로또 비교 테스트")
    void compareLottoTest() {
        //given
        Lotto target;
        List<Number> numbers = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            numbers.add(new Number(i));
        }
        numbers.add(new Number(13));

        target = new Lotto(numbers);

        //when
        int result = lotto.compareLotto(target);

        //then
        Assertions.assertEquals(5, result); //1,2,3,4,5 다섯개 일치
    }

    @Test
    @DisplayName("보너스 번호 비교 테스트")
    void compareLottoWithBonusTest() {
        //given
        int bonusNum1 = 1;
        int bonusNum2 = 11;

        //when
        int result1 = lotto.compareLottoWithBonus(new Number(bonusNum1));
        int result2 = lotto.compareLottoWithBonus(new Number(bonusNum2));

        //then
        Assertions.assertEquals(1, result1); //1개 일치
        Assertions.assertEquals(0, result2); //일치x
    }
}