package lotto.view;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void printManualInputGuide() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printLottoBundle(int manualPurchaseCount, int size, String stringLottos) {
        int randomPurchaseCount = size - manualPurchaseCount;
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.%n", manualPurchaseCount, randomPurchaseCount);
        System.out.println(stringLottos);
    }

    public static void printLottoResults(int earningRate, String rankString) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(rankString);
        System.out.printf("총 수익률은 %s%%입니다.", earningRate);
    }
}
