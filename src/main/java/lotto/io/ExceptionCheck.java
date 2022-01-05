package lotto.io;

import lotto.domain.Lotto;

import java.util.List;

public class ExceptionCheck {
    public static void checkValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("잘못된 구매금액입니다!");
        }
    }

    public static void checkValidWinningNumberList(List<Integer> winningNumber) {
        checkValidWinningNumberLength(winningNumber);
        checkDuplicatedWinningNumber(winningNumber);
    }

    private static void checkValidWinningNumberLength(List<Integer> winningNumber){
        if (winningNumber.size() != Lotto.LENGTH) {
            throw new IllegalArgumentException("잘못된 당첨 번호 개수입니다!");
        }
    }

    private static void checkDuplicatedWinningNumber(List<Integer> winningNumber) {
        int result = (int) winningNumber.stream().distinct().count();
        if (result != Lotto.LENGTH) {
            throw new IllegalArgumentException("당첨 번호에 중복이 존재합니다!");
        }
    }

    public static void checkValidBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("잘못된 보너스 볼 범위입니다!");
        }
    }

    public static void checkBonusNumberInWinningNumber(int bonus, List<Integer> winningNumber){
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("입력한 보너스 볼이 이미 당첨 번호에 있습니다!");
        }
    }
}

