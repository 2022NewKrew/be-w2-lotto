package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
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

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumbers = scanner.nextLine().split(DELIMITER);

        return Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
