package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.RandomLottoNumberGenerator.NUMBERS_TO_PICK;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param prompt 출력할 문자열
     * @return {@link #scanner}로부터 입력받은 자연수
     */
    public int getPositiveIntFromScanner(String prompt) {
        System.out.print(prompt);

        int input;
        while (!scanner.hasNextInt() || (input = scanner.nextInt()) <= 0) {
            System.out.println("** 자연수를 입력해주세요 **");
            scanner.next();
        }
        scanner.nextLine(); // 개행문자 제거
        return input;
    }

    /**
     * @param prompt 출력할 문자열
     * @return {@value lotto.domain.RandomLottoNumberGenerator#NUMBERS_TO_PICK}개의 자연수로 구성된 {@link Set}
     */
    public Set<Integer> getWinnerNumbersFromScanner(String prompt) {
        System.out.print(prompt);
        Set<Integer> result = new TreeSet<>();
        String input;
        while (result.size() < NUMBERS_TO_PICK) {
            result = getNumbers();
        }
        return result;
    }

    private Set<Integer> getNumbers() {
        Set<Integer> result = new HashSet<>();
        try {
            String input;
            input = scanner.nextLine();
            result = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toSet());
        } catch (NumberFormatException e) {
            System.out.println("** 컴마(,)로 구분된 숫자만 입력해주세요 **");
        }
        return result;
    }
}
