package controller;

import controller.scanner.PositiveIntArrayScanner;
import controller.scanner.PositiveIntScanner;
import domain.Lotto;
import domain.LottoResult;
import service.LottoService;

import java.util.ArrayList;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private final LottoService service = new LottoService();

    public void start() {
        buyLottoFromCli();
        showAllLotto();
        ArrayList<Integer> winningNumber = getWinningNumberFromCli();
        int bonusNumber = getBonusNumberFromCli();
        showWinningStats(winningNumber, bonusNumber);
    }

    private void buyLottoFromCli() {
        int amount = getAmountFromCli();
        int numOfPurchases = amount / LOTTO_PRICE;
        for (int i = 0; i < numOfPurchases; ++i) {
            service.createLotto();
        }
        System.out.printf("%d개를 구매했습니다.", numOfPurchases);
    }

    private int getAmountFromCli() {
        System.out.println("구입금액을 입력해 주세요.");
        PositiveIntScanner scanner = new PositiveIntScanner();
        return scanner.getValue();
    }

    private void showAllLotto() {
        ArrayList<Lotto> lottoList = service.getAllLotto();
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    private ArrayList<Integer> getWinningNumberFromCli() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        PositiveIntArrayScanner scanner = new PositiveIntArrayScanner();
        scanner.setArraySize(6);
        scanner.setMaxRange(45);
        return scanner.getValue();
    }

    private int getBonusNumberFromCli() {
        System.out.println("보너스 볼을 입력해 주세요.");
        PositiveIntScanner scanner = new PositiveIntScanner();
        return scanner.getValue();
    }

    private void showWinningStats(ArrayList<Integer> winningNumber, int bonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        LottoResult result = service.getLottoResult(winningNumber, bonusNumber);
        System.out.println(result.render());
        float yield = result.getYieldByPercent(LOTTO_PRICE);
        System.out.printf("총 수익률은 %.2f%%입니다.%n", yield);
    }
}
