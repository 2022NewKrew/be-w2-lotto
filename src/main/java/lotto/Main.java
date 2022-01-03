package lotto;

import lotto.domain.*;
import lotto.io.CLIInputManager;
import lotto.io.CLIOutputManager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final CLIInputManager im = new CLIInputManager();
    public static final CLIOutputManager om = new CLIOutputManager();
    public static final PurchaseManager pm = new PurchaseManager();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PurchaseInfo purchaseInfo = im.getPurchaseAmount(scanner);
            List<Lotto> lottoList = pm.purchase(purchaseInfo);
            om.printAllLotto(lottoList);

            List<Integer> winningNumber = im.getWinningNumber(scanner);
            WinningInfo winningInfo = new WinningInfo(lottoList, winningNumber);
            om.printPrizes(purchaseInfo, winningInfo);
        }
    }
}
