package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine().trim());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] values = scanner.nextLine().split(",");
        List<Integer> winningNumbers = Arrays.stream(values)
            .map(value -> Integer.parseInt(value.trim()))
            .collect(Collectors.toList());
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String value = scanner.nextLine().trim();
        System.out.println();
        return Integer.parseInt(value);
    }
}
