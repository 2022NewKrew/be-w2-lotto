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
            int purchaseAmount = getPurchaseAmountAndCheck(scanner);
            int totalNumOfPurchase = PurchaseInfo.getInitialNumOfPurchase(purchaseAmount);
            int manualLottoCount = getManualLottoCountAndCheck(scanner, totalNumOfPurchase);
            List<Lotto> manualLottoList = getManualLottoAndCheck(scanner, manualLottoCount);

            PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount, manualLottoCount);
            List<Lotto> lottoList = pm.purchase(purchaseInfo, manualLottoList);
            om.printAllLotto(lottoList);

            List<Integer> winningNumber = getWinningNumberAndCheck(scanner);
            int bonusNumber = getBonusNumberAndCheck(scanner, winningNumber);

            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            om.printPrizes(purchaseInfo, winningInfo);
        }
    }

    private static int getPurchaseAmountAndCheck(Scanner scanner) {
        int purchaseAmount = im.getPurchaseAmount(scanner);
        ExceptionCheck.checkValidPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static int getManualLottoCountAndCheck(Scanner scanner, int totalNumOfPurchase) {
        int manualLottoCount = im.getManualLottoCount(scanner);
        ExceptionCheck.checkValidManualLottoCount(manualLottoCount, totalNumOfPurchase);
        return manualLottoCount;
    }

    private static List<Lotto> getManualLottoAndCheck(Scanner scanner, int manualLottoCount) {
        List<Lotto> manualLottoList = im.getManualLotto(scanner, manualLottoCount);
        ExceptionCheck.checkValidManualLotto(manualLottoList, manualLottoCount);
        return manualLottoList;
    }

    private static List<Integer> getWinningNumberAndCheck(Scanner scanner) {
        List<Integer> winningNumber = im.getWinningNumber(scanner);
        ExceptionCheck.checkValidNumberList(winningNumber);
        return winningNumber;
    }

    private static int getBonusNumberAndCheck(Scanner scanner, List<Integer> winningNumber) {
        int bonusNumber = im.getBonusNumber(scanner);
        ExceptionCheck.checkValidBonusNumber(bonusNumber);
        ExceptionCheck.checkBonusNumberInWinningNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }
}
