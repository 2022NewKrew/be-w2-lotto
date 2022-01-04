package view;

import domain.Lotto;
import domain.LottoPrize;
import service.LottoService;

import java.util.List;

public class HomeView {
    private final LottoService lottoService;

    public HomeView(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void printInputBuyView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputManualSize() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printInputManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public void printInputWinningNumbersView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printBuySuccessView(int inputSizeManual) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", inputSizeManual, lottoService.getSize() - inputSizeManual);
        printLottos();
    }

    private void printLottos() {
        for (Lotto lotto : lottoService.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public void printResults() {
        List<Integer> results = lottoService.getWinningResult();
        System.out.println("당첨 통계 =====");
        for (int i = 5; i >= 1; i--) {
            System.out.printf("%d등. %d개 일치 %s(%d원)- %d개%n"
                    , i
                    , LottoPrize.getWithRanking(i).getMatchingNum()
                    , (i == 2) ? "보너스 볼 일치" : ""
                    , LottoPrize.PRICES[i]
                    , results.get(i));
        }
        System.out.printf("총 수익률은 %d%%입니다.%n", (int) (lottoService.getProfit() / (double) lottoService.getBuyPrice() * 100.0));
    }
}
