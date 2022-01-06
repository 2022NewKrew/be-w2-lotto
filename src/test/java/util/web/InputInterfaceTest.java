package util.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputInterfaceTest {
    InputInterface inputInterface = new InputInterface();

    @Test
    @DisplayName("구입 금액보다 많은 수의 로또를 구입하는 비정상 테스트")
    void validatePurchaseMoreThanBudgetTest() {
        // given
        int budget = 15000;
        int numberofManualLotto = 16;

        // when
        inputInterface.validatePurchaseMoreThanBudget(budget, numberofManualLotto);
    }

    @Test
    @DisplayName("로도 번호 안에 중복된 숫자가 있는 비정상 테스트")
    void validateRedundantNumberInTicketTest() {
        // given
        List<Integer> ticket = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 5));

        // when
        inputInterface.validateRedundantNumberInTicket(ticket);
    }

    @Test
    @DisplayName("당첨 로또 번호에 보너스 볼이 중복되어 있는 비정상 테스트")
    void validateBonusNumberInWinningNumberTest() {
        // given
        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonuseNumber = 6;

        // when
        inputInterface.validateBonusNumberInWinningNumber(winningNumbers, bonuseNumber);
    }
}