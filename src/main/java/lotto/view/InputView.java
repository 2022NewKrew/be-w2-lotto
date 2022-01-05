package lotto.view;

import lotto.domain.Constants;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String NUMBERS_PATTERN = "((\\d{1,2} *, *){5}(\\d{1,2}) *)";
    public static final String DELIMITER = "\\s*,\\s*";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine()) / Constants.LOTTO_PRICE;
    }

    public int inputManualPurchaseCount(int purchaseCount) {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualPurchaseCount = Integer.parseInt(scanner.nextLine());
        validateManualPurchaseCount(purchaseCount, manualPurchaseCount);
        return manualPurchaseCount;
    }

    private void validateManualPurchaseCount(int purchaseCount, int manualPurchaseCount) {
        if (purchaseCount - manualPurchaseCount < 0) {
            throw new IllegalArgumentException("구입한 로또의 수보다 더 많은 수동 로또를 구매할 수 없습니다.");
        }
    }

    public List<LottoNumbers> inputManualLottoNumbers(int manualPurchaseCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualPurchaseCount; i++) {
            lottoNumbers.add(inputManualLottoNumber());
        }
        return lottoNumbers;
    }

    private LottoNumbers inputManualLottoNumber() {
        String stringNumbers = scanner.nextLine().trim();
        validateStringNumbers(stringNumbers);

        String[] manualLottoNumbers = stringNumbers.split(DELIMITER);

        return new LottoNumbers(Arrays.stream(manualLottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public LottoNumbers inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String stringNumbers = scanner.nextLine().trim();
        validateStringNumbers(stringNumbers);

        String[] winningNumbers = stringNumbers.split(DELIMITER);

        return new LottoNumbers(Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void validateStringNumbers(String stringNumbers) {
        if (!stringNumbers.matches(NUMBERS_PATTERN)) {
            throw new IllegalArgumentException("숫자 6개만 입력해주세요.");
        }
    }

    public int inputBonusNumber(LottoNumbers winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(LottoNumbers winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 중복될 수 없습니다.");
        }
    }
}
