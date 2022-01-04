package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;

public class LottoInputScanner {
    private final ValidationChecker checker = new ValidationChecker();
    private final Scanner sc = new Scanner(System.in);

    public long getPurchaseAmount() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        long purchaseAmount = Long.parseLong(sc.nextLine());
        if (!checker.checkPositiveLong(purchaseAmount) || !checker.checkAmountUnit(purchaseAmount)) {
            throw new IllegalArgumentException("금액을 확인해주십시오.(lotto는 1000원 단위로 구매 가능합니다.)");
        }
        return purchaseAmount;
    }

    public List<Integer> getWinningDigits() throws IllegalArgumentException {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningDigitList = Arrays.stream(sc.nextLine().split(SEPARATOR))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());

        if (!checker.checkDigitsInLotto(winningDigitList) || !checker.checkDuplication(winningDigitList) || !checker.checkNumOfDigits(winningDigitList)) {
            throw new IllegalArgumentException("당첨 번호는 1~45사이의 숫자 6개로 중복없이 입력바랍니다.");
        }

        return winningDigitList;
    }

    public int getWinningBonusDigit(List<Integer> winningDigitList) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = sc.nextInt();

        if (!checker.checkDigit(bonus) || !checker.checkDuplication(winningDigitList, bonus)) {
            throw new IllegalArgumentException("보너스 숫자는 1~45 사이의 값이며 당첨 번호와 중복될 수 없습니다.");
        }

        return bonus;
    }
}
