package lotto.view;

import lotto.domain.Rank;

public class OutputView {

    private OutputView() {}

    public static void printLottos(int size, String stringLottos) {
        System.out.println(size + "개를 구매했습니다.");
        System.out.println(stringLottos);
    }

    public static void printLottoResults(int earningRate, String rankString) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(rankString);
        System.out.printf("총 수익률은 %s%%입니다.", earningRate);
    }
}
