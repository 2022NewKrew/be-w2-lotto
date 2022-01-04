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
            PurchaseInfo purchaseInfo = im.getPurchaseAmount(scanner);
            List<Lotto> lottoList = pm.purchase(purchaseInfo);
            om.printAllLotto(lottoList);

            List<Integer> winningNumber = im.getWinningNumber(scanner);
            int bonusNumber = im.getBonusNumber(scanner);
            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber, bonusNumber);
            om.printPrizes(purchaseInfo, winningInfo);
        }
    }
}
