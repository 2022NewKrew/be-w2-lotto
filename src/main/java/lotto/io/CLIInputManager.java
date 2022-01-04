package lotto.io;

import java.util.*;

public class CLIInputManager implements InputManager {
    private static final String PURCHASE_AMOUNT_TITLE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_TITLE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_TITLE = "보너스 볼을 입력해 주세요.";

    public int getPurchaseAmount(Scanner scanner) {
        System.out.println(PURCHASE_AMOUNT_TITLE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getWinningNumber(Scanner scanner) {
        System.out.println(WINNING_NUMBER_TITLE);
        List<Integer> result = new ArrayList<>();
        for (String element : scanner.nextLine().replace(" ", "").split(",")) {
            result.add(Integer.parseInt(element));
        }
        Collections.sort(result);
        return Collections.unmodifiableList(result);
    }

    public int getBonusNumber(Scanner scanner) {
        System.out.println(BONUS_NUMBER_TITLE);
        return Integer.parseInt(scanner.nextLine());
    }
}


