package service;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomSixNumbersServiceTest {
    static List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = RandomSixNumbersService.getRandomSixNumbers();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("로또 번호 갯수가 6개인가")
    @Test
    void randomLottoHasSixNumbers() {
        assertEquals(6, numbers.size());
    }

    @DisplayName("로또 번호의 범위가 1~45인가")
    @Test
    void randomLottoNumbersBetweenOneToFortyFive() {
        assertTrue(numbers.stream().allMatch(v -> v >= 1 && v <= 45));
    }
}