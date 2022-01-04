package lotto.view;

import lotto.domain.LottoTicket;
import lotto.exception.InvalidInputFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputAmountForPurchase() throws InvalidInputFormatException {
        System.out.println("구입금액을 입력해 주세요.");
        int amountForPurchase = inputNumber();
        validateAmount(amountForPurchase);
        return amountForPurchase;
    }

    private int inputNumber() throws InvalidInputFormatException {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputFormatException();
        }
    }

    private void validateAmount(int amount) throws InvalidInputFormatException {
        if (amount <= 0) {
            throw new InvalidInputFormatException("양수를 입력해야 합니다.");
        }

        if (amount < LottoTicket.PRICE) {
            throw new InvalidInputFormatException("금액이 부족하여 로또를 구매할 수 없습니다.");
        }
    }

    public List<Integer> inputWinningNumbers() throws InvalidInputFormatException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numbers = inputDistinctNumbers();

        validateWinningNumbers(numbers);

        return numbers;
    }

    private List<Integer> inputDistinctNumbers() throws InvalidInputFormatException {
        try {
            return Arrays.stream(scanner.nextLine().split(COMMA))
                    .map(string -> Integer.parseInt(string.trim()))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidInputFormatException();
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) throws InvalidInputFormatException {
        if (!isValidSizeOfNumbers(winningNumbers)) {
            throw new InvalidInputFormatException("중복된 숫자를 포함하고 있거나 입력한 문자 리스트의 길이가 잘못 되었습니다.");
        }

        if (winningNumbers.stream().anyMatch(number -> !isValidRangeNumber(number))) {
            throw new InvalidInputFormatException("입력된 숫자의 범위가 잘못 되었습니다. (유효한 숫자 범위 : " + LottoTicket.MIN_NUMBER + " ~ " + LottoTicket.MAX_NUMBER + ")");
        }
    }

    private boolean isValidSizeOfNumbers(List<Integer> numbers) {
        return numbers.size() == LottoTicket.LENGTH_OF_NUMBERS;
    }

    private boolean isValidRangeNumber(int number) {
        return number >= LottoTicket.MIN_NUMBER && number <= LottoTicket.MAX_NUMBER;
    }

    public int inputBonusNumber() throws InvalidInputFormatException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = inputNumber();
        if (!isValidRangeNumber(bonusNumber)) {
            throw new InvalidInputFormatException("입력된 숫자의 범위가 잘못 되었습니다. (유효한 숫자 범위 : " + LottoTicket.MIN_NUMBER + " ~ " + LottoTicket.MAX_NUMBER + ")");
        }
        return bonusNumber;
    }
}
