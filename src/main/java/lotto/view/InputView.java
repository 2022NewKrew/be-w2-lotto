package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String NUMBERS_PATTERN = "((\\d{1,2} *, *){5}(\\d{1,2}) *)";
    private static final String DELIMITER = "\\s*,\\s*";
    private static final int LOTTO_PRICE = 1000;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseCount = Integer.parseInt(scanner.nextLine()) / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
        return purchaseCount;
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
