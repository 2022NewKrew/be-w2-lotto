package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    static ArrayList<Number> numberList;
    static Lotto lotto;

    @BeforeEach
    void setUp(){
        numberList = new ArrayList<>(Arrays.asList(new Number(1),new Number(2),
                new Number(3),new Number(4),
                new Number(5),new Number(6)));
        lotto = new Lotto(numberList);
    }

    @Test
    @DisplayName("두 로또 번호중 교집합의 개수 구하기 테스트")
    void getHitCount() {
        ArrayList<Number> numberList2 = new ArrayList<>(Arrays.asList(new Number(1),new Number(2),
                new Number(13),new Number(14),
                new Number(15),new Number(16)));
        Lotto lotto2 = new Lotto(numberList2);
        assertEquals(lotto.getHitCount(lotto2), 2);
    }

    @Test
    @DisplayName("로또번호에 매개변수로 전달한 숫자가 있는지 체크 테스트")
    void isHit() {
        assertEquals(lotto.isHit(new Number(1)),1);
        assertNotEquals(lotto.isHit(new Number(2)), 0);
    }
}