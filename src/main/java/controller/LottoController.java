package controller;

import controller.type.PositiveInteger;
import controller.type.PositiveIntegerArrayList;
import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoResult;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Lotto> lottoList = new ArrayList<>();
    private WinningLotto winningLotto;

    public void start() {
        buyLottoFromCli();
        showAllLotto();
        createWinningLottoFromCli();
        showWinningStats();
    }

    private void buyLottoFromCli() {
        int numOfPurchases = getNumOfPurchasesFromCli();
        int numOfManualPurchases = getNumOfManualPurchasesFromCli();
        validateNumOfManualPurchases(numOfManualPurchases, numOfPurchases);
        buyLottoManuallyFromCli(numOfManualPurchases);
        int numOfAutoPurchases = numOfPurchases - numOfManualPurchases;
        buyLottoAutomaticallyFromCli(numOfAutoPurchases);
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                numOfManualPurchases, numOfAutoPurchases);
    }

    private int getNumOfPurchasesFromCli() {
        System.out.println("구입금액을 입력해 주세요.");
        return PositiveInteger.parse(scanner.nextLine()) / LOTTO_PRICE;
    }

    private int getNumOfManualPurchasesFromCli() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return PositiveInteger.parse(scanner.nextLine());
    }

    private void validateNumOfManualPurchases(int numOfManualPurchases, int numOfPurchases) {
        if (numOfPurchases < numOfManualPurchases) {
            throw new IllegalArgumentException("금액보다 구매하는 양이 많습니다.");
        }
    }

    private void buyLottoManuallyFromCli(int numOfPurchases) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < numOfPurchases; ++i) {
            ArrayList<Integer> lottoNumber = getLottoNumberFromCli();
            lottoList.add(new Lotto(lottoNumber));
        }
    }

    private ArrayList<Integer> getLottoNumberFromCli() {
        return PositiveIntegerArrayList.parse(scanner.nextLine());
    }

    private void buyLottoAutomaticallyFromCli(int numOfPurchases) {
        for (int i = 0; i < numOfPurchases; ++i) {
            lottoList.add(LottoGenerator.generateRandomly());
        }
    }

    private void showAllLotto() {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    private void createWinningLottoFromCli() {
        ArrayList<Integer> winningNumber = getWinningNumberFromCli();
        int bonusNumber = getBonusNumberFromCli();
        winningLotto = new WinningLotto(winningNumber, bonusNumber);
    }

    private ArrayList<Integer> getWinningNumberFromCli() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return PositiveIntegerArrayList.parse(scanner.nextLine());
    }

    private int getBonusNumberFromCli() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return PositiveInteger.parse(scanner.nextLine());
    }

    private void showWinningStats() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        LottoResult result = new LottoResult(lottoList, winningLotto);
        System.out.println(result.render());
        float yield = result.getYieldByPercent(LOTTO_PRICE);
        System.out.printf("총 수익률은 %.2f%%입니다.%n", yield);
    }
}
