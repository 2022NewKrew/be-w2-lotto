package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PurchaseInfo;

import java.util.List;

public class ExceptionCheck {
    public static void checkValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("잘못된 구매금액입니다!");
        } else if (purchaseAmount < PurchaseInfo.PRICE) {
            throw new IllegalArgumentException("입력한 구매금액이 로또의 가격보다 작습니다!");
        }
    }

    public static void checkValidManualLottoCount(int manualLottoCount, int totalNumOfPurchase) {
        if (manualLottoCount > totalNumOfPurchase) {
            throw new IllegalArgumentException("수동 구매 로또 수가 구매 가능한 로또 수보다 많습니다!");
        }
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("수동 구매 로또 수는 음수가 될 수 없습니다!");
        }
    }

    public static void checkValidManualLotto(List<Lotto> manualLottoList, int manualLottoCount) {
        if (manualLottoCount != manualLottoList.size()) {
            throw new IllegalArgumentException("수동 구매 로또 수와 다른 개수의 로또가 입력되었습니다!");
        }
    }

    public static void checkValidNumberList(List<Integer> winningNumber) {
        checkValidNumberLength(winningNumber);
        checkDuplicatedNumber(winningNumber);
    }

    private static void checkValidNumberLength(List<Integer> winningNumber){
        if (winningNumber.size() != Lotto.LENGTH) {
            throw new IllegalArgumentException("잘못된 번호 개수입니다!");
        }
    }

    private static void checkDuplicatedNumber(List<Integer> winningNumber) {
        int result = (int) winningNumber.stream().distinct().count();
        if (result != Lotto.LENGTH) {
            throw new IllegalArgumentException("번호에 중복이 존재합니다!");
        }
    }

    public static void checkValidBonusNumber(int bonus) {
        if (bonus < LottoGenerator.MIN_NUM || bonus > LottoGenerator.MAX_NUM) {
            throw new IllegalArgumentException("잘못된 보너스 볼 범위입니다!");
        }
    }

    public static void checkBonusNumberInWinningNumber(int bonus, List<Integer> winningNumber){
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("입력한 보너스 볼이 이미 당첨 번호에 있습니다!");
        }
    }
}

