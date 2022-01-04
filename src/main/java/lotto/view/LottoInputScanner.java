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
        if (!checker.checkPositiveNumber(purchaseAmount) || !checker.checkAmountUnit(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount;
    }

    public int getNumOfManualLottos() throws IllegalArgumentException {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int numOfManualLottos = Integer.parseInt(sc.nextLine());

        if (!checker.checkPositiveNumber(numOfManualLottos)) {
            throw new IllegalArgumentException();
        }
        return numOfManualLottos;
    }

    public List<Integer> getDigits() throws IllegalArgumentException {
        List<Integer> winningDigitList = Arrays.stream(sc.nextLine().split(SEPARATOR))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());

        if (!checker.checkDigitsInLotto(winningDigitList) || !checker.checkDuplication(winningDigitList) || !checker.checkNumOfDigits(winningDigitList)) {
            throw new IllegalArgumentException();
        }
        return winningDigitList;
    }

    public int getWinningBonusDigit(List<Integer> winningDigitList) throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = sc.nextInt();

        if (!checker.checkDigit(bonus) || !checker.checkDuplication(winningDigitList, bonus)) {
            throw new IllegalArgumentException();
        }
        return bonus;
    }
}
