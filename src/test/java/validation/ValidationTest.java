package validation;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    @DisplayName("[성공] notLessThanInt")
    void notLessThanInt() {
        int n1 = 10;
        int n2 = 1;

        Validation.notLessThanLong(n1, n2, RuntimeException::new);
    }

    @Test
    @DisplayName("[실패] 보다 작은 숫자가 들어올시 예외를 던져야 한다")
    void notLessThanInt_Failed() {
        int n1 = -100;
        int n2 = 1;

        Assertions.assertThrows(RuntimeException.class,
                () -> Validation.notLessThanLong(n1, n2, RuntimeException::new));
    }

    @Test
    @DisplayName("[성공] notMoreThanInt")
    void notMoreThanInt() {
        int n1 = 10;
        int n2 = 45;

        Validation.notMoreThanLong(n1, n2, RuntimeException::new);
    }

    @Test
    @DisplayName("[실패] 보다 큰 숫자가 들어올시 예외를 던져야 한다")
    void notMoreThanInt_Failed() {
        int n1 = 46;
        int n2 = 45;

        Assertions.assertThrows(RuntimeException.class,
                () -> Validation.notMoreThanLong(n1, n2, RuntimeException::new));
    }

    @Test
    @DisplayName("[성공] lengthShouldBe")
    void lengthShouldBe() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        int lengthToBe = 6;

        Validation.sizeShouldBe(set, lengthToBe, RuntimeException::new);
    }

    @Test
    @DisplayName("[실패] 로또 개수가 다를시 예외를 던져야 한다")
    void lengthShouldBe_Failed() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
        int lengthToBe = 6;

        Assertions.assertThrows(RuntimeException.class,
                () -> Validation.sizeShouldBe(set, lengthToBe, RuntimeException::new));
    }
}