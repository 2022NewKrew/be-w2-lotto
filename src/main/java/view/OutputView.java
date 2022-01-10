package view;

import DTO.ResultDTO;

public class OutputView {
    private OutputView() {
        throw new AssertionError();
    }

    public static void printPayInputError() {
        System.out.println("적어도 한개의 복권을 구매해주세요 (개당 1000원)");
    }

    public static void printManualNumberError(int totalNum) {
        System.out.printf("0부터 %d까지의 정수 중 하나의 수를 입력해주세요\n", totalNum);
    }

    public static void printManualInputError() {
        System.out.println("1부터 45까지의 서로 다른 숫자 6개를 ','로 나누어서 입력해주세요.");
    }

    public static void printBonusInputError() {
        System.out.println("1부터 45까지의 정수 중에서 당첨번호에 포함되지 않는 수 하나를 입력해주세요.");
    }

    public static void announceBeforeManualLine() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void announceBeforeWinningLine() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printLottoLine(String lottoLineStr) {
        System.out.println(lottoLineStr);
    }

    public static void printAutoManualNum(int autoNum, int manualNum) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualNum, autoNum);
    }

    public static void printPreResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printResult(ResultDTO result) {
        if (result.isMatchBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n",
                    result.getMatchNum(), result.getPrice(), result.getNumLotto());
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개\n", result.getMatchNum(), result.getPrice(), result.getNumLotto());
    }

    public static void printYield(float yield) {
        System.out.printf("총 수익률은 %f%%입니다.", yield);
    }
}
