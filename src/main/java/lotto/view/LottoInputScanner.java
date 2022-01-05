package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;

public class LottoInputScanner {
    private final InputValidationChecker checker = new InputValidationChecker();
    private final Scanner sc = new Scanner(System.in);

    public long getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        long purchaseAmount = Long.parseLong(sc.nextLine());
        if (checker.checkPositiveNumber(purchaseAmount) || checker.checkAmountUnit(purchaseAmount)) {
            throw new InputMismatchException("금액을 확인해주십시오.(lotto는 1000원 단위로 구매 가능합니다.)");
        }
        return purchaseAmount;
    }

    public long getNumOfManualLottos() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        long numOfManualLottos = Long.parseLong(sc.nextLine());

        if (checker.checkPositiveNumber(numOfManualLottos)) {
            throw new InputMismatchException("구매할 로또 수는 0이상 정수여야 합니다.");
        }
        return numOfManualLottos;
    }

    public List<Integer> getDigits() {
        return Arrays.stream(sc.nextLine().split(SEPARATOR))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    public int getWinningBonusDigit() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }
}
