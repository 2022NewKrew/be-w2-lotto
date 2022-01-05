package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.InputChecker;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    static Lotto lotto;
    static InputChecker checker;

    @BeforeAll
    static void init() {
        lotto = new Lotto();
        checker = new InputChecker();
    }

    @DisplayName("로또 번호는 반드시 {Lotto.NUMBER_COUNT}개여야 한다.")
    @Test
    void createLottoTicketWithIncorrectCountOfNumbers() {
        List<Integer> lessThanNecessary = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> moreThanNecessary = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        try {
            new LottoTicket(lotto, checker, lessThanNecessary);
            new LottoTicket(lotto, checker, moreThanNecessary);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("로또 번호는 6개의 숫자로 이루어져야 합니다.");
            return;
        }
        fail();
    }

    @DisplayName("로또 번호가 중복되어서는 안된다.")
    @Test
    void createLottoTicketWithDuplicatedItemList() {
        List<Integer> duplicatedItemList = Arrays.asList(1, 1, 2, 3, 4, 5);

        try {
            new LottoTicket(lotto, checker, duplicatedItemList);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("로또 번호는 중복된 번호를 허용하지 않습니다.");
            return;
        }
        fail();
    }

    @DisplayName("로또 번호는 1 ~ 45 사이의 숫자만 가능하다.")
    @Test
    void createLottoTicketWithOutOfRangedItemList() {
        List<Integer> outOfRangedItemList = Arrays.asList(0, 1, 2, 3, 4, 46);
        try {
            new LottoTicket(lotto, checker, outOfRangedItemList);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
            return;
        }
        fail();
    }
}