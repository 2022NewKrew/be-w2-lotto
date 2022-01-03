package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.PurchaseInfo;

import java.util.*;

public class CLIInputManager implements InputManager {
    public PurchaseInfo getPurchaseAmount(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        checkValidPurchaseAmount(purchaseAmount);
        PurchaseInfo pi = new PurchaseInfo(purchaseAmount);
        System.out.printf("%d개를 구매했습니다.", pi.getNumOfPurchase());
        return pi;
    }

    public List<Integer> getWinningNumber(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> result = new ArrayList<>();
        for (String element : scanner.nextLine().replace(" ", "").split(",")) {
            result.add(Integer.parseInt(element));
        }
        Collections.sort(result);
        checkValidWinningNumberList(result);
        return result;
    }

    private void checkValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("잘못된 구매금액입니다!");
        }
    }

    private void checkValidWinningNumberList(List<Integer> winningNumber) {
        checkValidWinningNumberLength(winningNumber);
        for (int i = 0; i < winningNumber.size() - 1; i++) {
            checkValidWinningNumberEach(winningNumber.get(i), winningNumber.get(i + 1));
        }
    }

    private void checkValidWinningNumberLength(List<Integer> winningNumber){
        if (winningNumber.size() != Lotto.LENGTH) {
            throw new IllegalArgumentException("잘못된 당첨 번호 개수입니다!");
        }
    }

    private void checkValidWinningNumberEach(int current, int next) {
        if (current == next) {
            throw new IllegalArgumentException("당첨 번호에 중복이 존재합니다!");
        }
    }
}
