package lotto.view;

import lotto.IllegalLottoNumberException;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

    public List<String> getManualLottoNumberStringList(long numOfManualLottos) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return LongStream.range(0, numOfManualLottos)
                .mapToObj(l -> sc.nextLine())
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getWinningLottoNumberList() throws IllegalLottoNumberException {
        return Arrays.stream(sc.nextLine().split(SEPARATOR))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .collect(Collectors.toList());
    }

    public LottoNumber getBonusNumber() throws IllegalLottoNumberException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(sc.nextLine()));
    }
}
