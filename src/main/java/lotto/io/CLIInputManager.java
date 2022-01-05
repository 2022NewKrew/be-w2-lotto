package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.*;

public class CLIInputManager implements InputManager {
    private static final String PURCHASE_AMOUNT_TITLE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_TITLE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_TITLE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_TITLE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_TITLE = "보너스 볼을 입력해 주세요.";

    public int getPurchaseAmount(Scanner scanner) {
        System.out.println(PURCHASE_AMOUNT_TITLE);
        return Integer.parseInt(scanner.nextLine());
    }

    public int getManualLottoCount(Scanner scanner) {
        System.out.println(MANUAL_LOTTO_COUNT_TITLE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Lotto> getManualLotto(Scanner scanner, int count) {
        System.out.println(MANUAL_LOTTO_TITLE);
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(LottoGenerator.generateManualLotto(getNumbersInput(scanner)));
        }
        return result;
    }

    public List<Integer> getWinningNumber(Scanner scanner) {
        System.out.println(WINNING_NUMBER_TITLE);
        return getNumbersInput(scanner);
    }

    public int getBonusNumber(Scanner scanner) {
        System.out.println(BONUS_NUMBER_TITLE);
        return Integer.parseInt(scanner.nextLine());
    }

    private List<Integer> getNumbersInput(Scanner scanner) {
        List<Integer> result = new ArrayList<>();
        for (String element : scanner.nextLine().replace(" ", "").split(",")) {
            result.add(Integer.parseInt(element));
        }
        ExceptionCheck.checkValidNumberList(result);
        Collections.sort(result);
        return Collections.unmodifiableList(result);
    }
}


