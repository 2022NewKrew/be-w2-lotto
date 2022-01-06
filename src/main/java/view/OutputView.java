package view;

import DTO.ResultDTO;

public class OutputView {
    private OutputView() {
    }

    public static void printPayInputError() {
        System.out.println("적어도 한개의 복권을 구매해주세요 (개당 1000원)");
    }

    public static void printWinningInputError() {
        System.out.println("1부터 45까지의 서로 다른 숫자 6개를 ','로 나누어서 입력해주세요.");
    }

    public static void printBonusInputError() {
        System.out.println("1부터 45까지의 정수 중에서 당첨번호에 포함되지 않는 수 하나를 입력해주세요.");
    }

    public static void printLottoLine(String lottoLineStr) {
        System.out.println(lottoLineStr);
    }

    public static void printPreResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printResult(ResultDTO result) {
        if (!result.isMatchBonus()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", result.getMatchNum(), result.getPrice(), result.getNumLotto());
            return;
        }
        System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n",
                result.getMatchNum(), result.getPrice(), result.getNumLotto());
    }

    public static void printYield(Long yield) {
        System.out.printf("총 수익률은 %d%%입니다.", yield);
    }
}
