package validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ValidationTest {

    @Test
    @DisplayName("[성공] notLessThanInt")
    void notLessThanInt() {
        int n1 = 10;
        int n2 = 1;

        Validation.notLessThanLong(n1, n2, new RuntimeException());
    }

    @Test
    @DisplayName("[실패] 보다 작은 숫자가 들어올시 예외를 던져야 한다")
    void notLessThanInt_Failed() {
        int n1 = -100;
        int n2 = 1;

        Assertions.assertThrows(RuntimeException.class,
                () -> Validation.notLessThanLong(n1, n2, new RuntimeException()));
    }

    @Test
    @DisplayName("[성공] notMoreThanInt")
    void notMoreThanInt() {
        int n1 = 10;
        int n2 = 45;

        Validation.notMoreThanInt(n1, n2, new RuntimeException());
    }

    @Test
    @DisplayName("[실패] 보다 큰 숫자가 들어올시 예외를 던져야 한다")
    void notMoreThanInt_Failed() {
        int n1 = 46;
        int n2 = 45;

        Assertions.assertThrows(RuntimeException.class,
                () -> Validation.notMoreThanInt(n1, n2, new RuntimeException()));
    }

    @Test
    @DisplayName("[성공] lengthShouldBe")
    void lengthShouldBe() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int lengthToBe = 6;

        Validation.lengthShouldBe(list, lengthToBe, new RuntimeException());
    }

    @Test
    @DisplayName("[실패] 리스트의 길이가 다를시 예외를 던져야 한다")
    void lengthShouldBe_Failed() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int lengthToBe = 6;

        Assertions.assertThrows(RuntimeException.class,
                () -> Validation.lengthShouldBe(list, lengthToBe, new RuntimeException()));
    }
}