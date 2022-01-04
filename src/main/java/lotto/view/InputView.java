package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.RandomLottoNumberGenerator.NUMBERS_TO_PICK;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

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

    public Set<Integer> getWinnerNumbersFromScanner(String prompt) {
        System.out.println(prompt);
        Set<Integer> result = new HashSet<>();
        String input;
        while (result.size() < NUMBERS_TO_PICK) {
            input = scanner.nextLine();
            result = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toSet());
        }
        return result;
    }
}
