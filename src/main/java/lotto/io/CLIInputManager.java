package lotto.io;

import lotto.domain.Lotto;

import java.util.*;

public class CLIInputManager implements InputManager {
    private static final String PURCHASE_AMOUNT_TITLE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_TITLE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_TITLE = "보너스 볼을 입력해 주세요.";

    public int getPurchaseAmount(Scanner scanner) {
        System.out.println(PURCHASE_AMOUNT_TITLE);
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        checkValidPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getWinningNumber(Scanner scanner) {
        System.out.println(WINNING_NUMBER_TITLE);
        List<Integer> result = new ArrayList<>();
        for (String element : scanner.nextLine().replace(" ", "").split(",")) {
            result.add(Integer.parseInt(element));
        }
        Collections.sort(result);
        checkValidWinningNumberList(result);
        return Collections.unmodifiableList(result);
    }

    public int getBonusNumber(Scanner scanner) {
        System.out.println(BONUS_NUMBER_TITLE);
        int bonus = Integer.parseInt(scanner.nextLine());
        checkValidBonusNumber(bonus);
        return bonus;
    }

    private static void checkValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("잘못된 구매금액입니다!");
        }
    }

    private static void checkValidWinningNumberList(List<Integer> winningNumber) {
        checkValidWinningNumberLength(winningNumber);
        for (int i = 0; i < winningNumber.size() - 1; i++) {
            checkValidWinningNumberEach(winningNumber.get(i), winningNumber.get(i + 1));
        }
    }

    private static void checkValidWinningNumberLength(List<Integer> winningNumber){
        if (winningNumber.size() != Lotto.LENGTH) {
            throw new IllegalArgumentException("잘못된 당첨 번호 개수입니다!");
        }
    }

    private static void checkValidWinningNumberEach(int current, int next) {
        if (current == next) {
            throw new IllegalArgumentException("당첨 번호에 중복이 존재합니다!");
        }
    }

    private static void checkValidBonusNumber(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("잘못된 보너스 볼 범위입니다!");
        }
    }
}


