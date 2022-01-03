package view;

import dto.MainDTO;

import java.util.List;

public class MainView {
    private static final int[] WINNING_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private final MainDTO mainDTO;

    public MainView(MainDTO mainDTO) {
        this.mainDTO = mainDTO;
    }

    public void printInputBuyView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningNumbersView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printBuySuccessView() {
        System.out.println(mainDTO.getSize() + "개를 구매했습니다.");
        printLottos();
    }

    private void printLottos() {
        for (LottoView lottoView : mainDTO.getLotto().getLottoViews()) {
            lottoView.printLotto();
        }
    }

    public void printResults() {
        List<Integer> results = mainDTO.getResults();
        long profit = 0;
        for (int i = 0; i <= 6; i++) {
            profit += results.get(i) * WINNING_MONEY[i];
        }
        System.out.println("당첨 통계 =====");
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", i, WINNING_MONEY[i], results.get(i));
        }
        System.out.printf("총 수익률은 %d%%입니다.%n", (int) (profit / (double) mainDTO.getBuyPrice() * 100.0));
    }
}
