package view;

import domain.Lotto;
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

    public void printInputWinningNumbersView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printBuySuccessView() {
        System.out.println(lottoService.getSize() + "개를 구매했습니다.");
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
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", i, LottoService.WINNING_MONEY[i], results.get(i));
        }
        System.out.printf("총 수익률은 %d%%입니다.%n", (int) (lottoService.getProfit() / (double) lottoService.getBuyPrice() * 100.0));
    }
}
