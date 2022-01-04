package view;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoLine(List<Integer> lottoLine) {
        System.out.println(lottoLine.toString());
    }

    public static void printPreResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printResult(int matchNum, int price, int lineNum) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", matchNum, price, lineNum);
    }

    public static void printYield(int yield) {
        System.out.printf("총 수익률은 %d%%입니다.", yield);
    }
}
