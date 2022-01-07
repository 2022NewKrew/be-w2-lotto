package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.*;
import java.util.stream.Stream;

public class CLIInputManager implements InputManager<Scanner> {
    private static final String CLI_PURCHASE_AMOUNT_TITLE = "구입금액을 입력해 주세요.";
    private static final String CLI_MANUAL_LOTTO_COUNT_TITLE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String CLI_MANUAL_LOTTO_TITLE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String CLI_WINNING_NUMBER_TITLE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String CLI_BONUS_NUMBER_TITLE = "보너스 볼을 입력해 주세요.";

    public int getPurchaseAmount(Scanner scanner) {
        System.out.println(CLI_PURCHASE_AMOUNT_TITLE);
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        ExceptionCheck.checkValidPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public int getManualLottoCount(Scanner scanner, int totalNumOfPurchase) {
        System.out.println(CLI_MANUAL_LOTTO_COUNT_TITLE);
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        ExceptionCheck.checkValidManualLottoCount(manualLottoCount, totalNumOfPurchase);
        return manualLottoCount;
    }

    public List<Lotto> getManualLotto(Scanner scanner, int manualLottoCount) {
        System.out.println(CLI_MANUAL_LOTTO_TITLE);
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoList.add(Parser.stringToManualLotto(scanner.nextLine()));
        }
        ExceptionCheck.checkValidManualLotto(manualLottoList, manualLottoCount);
        manualLottoList.forEach(lotto -> ExceptionCheck.checkValidNumberList(lotto.getNumbers()));
        return Collections.unmodifiableList(manualLottoList);
    }

    public List<Integer> getWinningNumber(Scanner scanner) {
        System.out.println(CLI_WINNING_NUMBER_TITLE);
        List<Integer> winningNumber = Parser.stringTotWinningNumber(scanner.nextLine());
        ExceptionCheck.checkValidNumberList(winningNumber);
        return winningNumber;
    }

    public int getBonusNumber(Scanner scanner, List<Integer> winningNumber) {
        System.out.println(CLI_BONUS_NUMBER_TITLE);
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        ExceptionCheck.checkValidBonusNumber(bonusNumber);
        ExceptionCheck.checkBonusNumberInWinningNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }
}


