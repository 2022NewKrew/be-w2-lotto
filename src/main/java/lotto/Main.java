package lotto;

import lotto.domain.*;
import lotto.io.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final InputManager im = new CLIInputManager();
    public static final OutputManager om = new CLIOutputManager();
    public static final PurchaseManager pm = new PurchaseManager();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PurchaseInfo purchaseInfo = new PurchaseInfo(getPurchaseAmountAndCheck(scanner));
            List<Lotto> lottoList = pm.purchase(purchaseInfo);
            om.printAllLotto(lottoList);

            List<Integer> winningNumber = getWinningNumberAndCheck(scanner);
            int bonusNumber = getBonusNumberAndCheck(scanner, winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            om.printPrizes(purchaseInfo, winningInfo);
        }
    }

    private static int getPurchaseAmountAndCheck(Scanner scanner) {
        int purchaseAmount = im.getPurchaseAmount(scanner);
        CLIExceptionCheck.checkValidPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static List<Integer> getWinningNumberAndCheck(Scanner scanner) {
        List<Integer> winningNumber = im.getWinningNumber(scanner);
        CLIExceptionCheck.checkValidWinningNumberList(winningNumber);
        return winningNumber;
    }

    private static int getBonusNumberAndCheck(Scanner scanner, List<Integer> winningNumber) {
        int bonusNumber = im.getBonusNumber(scanner);
        CLIExceptionCheck.checkValidBonusNumber(bonusNumber);
        CLIExceptionCheck.checkBonusNumberInWinningNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }
}
