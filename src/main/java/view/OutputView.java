package view;

import DTO.nNumber;

public class OutputView {
    private OutputView() {
    }

    public static void printWinningInputError() {
        System.out.println("1부터 45까지의 숫자 6개를 ','로 나누어서 입력해주세요.");
    }

    public static void printBonusInputError() {
        System.out.println("1부터 45까지의 정수 중에서 하나를 입력해주세요.");
    }

    public static void printLottoLine(nNumber lottoLine) {
        System.out.println(lottoLine.getPrintLine());
    }

    public static void printPreResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printResult(int matchNum, boolean hasBonus, Long price, int lineNum) {
        if (hasBonus) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", matchNum, price, lineNum);
            return;
        }
        System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", matchNum, price, lineNum);
    }

    public static void printYield(Long yield) {
        System.out.printf("총 수익률은 %d%%입니다.", yield);
    }
}
