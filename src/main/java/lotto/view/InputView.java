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
        return inputNumber();
    }

    private int inputNumber() throws InvalidInputFormatException {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputFormatException();
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
        validateLengthOfNumbers(winningNumbers, LottoTicket.LENGTH_OF_NUMBERS);
        validateRangeOfNumbers(winningNumbers, LottoTicket.MIN_NUMBER, LottoTicket.MAX_NUMBER);
    }

    private void validateLengthOfNumbers(List<Integer> numbers, int length) throws InvalidInputFormatException {
        if (numbers.size() != length) {
            throw new InvalidInputFormatException("중복된 숫자를 포함하고 있거나 입력한 문자 리스트의 길이가 잘못 되었습니다.");
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers, int min, int max) throws InvalidInputFormatException {
        if (numbers.stream().anyMatch(number -> number < min || number > max)) {
            throw new InvalidInputFormatException("입력된 숫자의 범위가 잘못 되었습니다. (범위 : " + min + " ~ " + max + ")");
        }
    }
}
