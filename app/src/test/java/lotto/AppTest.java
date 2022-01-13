/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {

    @DisplayName("전체 Lotto 테스트")
    @Test
    void lottoTest(){
        int bonusBall;
        int moneyToGame = 100000;
        ArrayList<Integer> winningNumber;

        Lotto lotto = new Lotto(moneyToGame);
        OutputView.displayPurchaseGames(lotto.getManualGames(), lotto.getAutoGames());

        winningNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        OutputView.displayCandidateNumber(winningNumber);

        bonusBall = 7;

        lotto.checkWinning(winningNumber, bonusBall);
        OutputView.displayWinningResults(lotto);
    }


}
