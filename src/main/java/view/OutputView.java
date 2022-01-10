package view;

import java.util.List;

public class OutputView {
    public static void printLabel(String label) {
        System.out.println(label);
    }

    public static void printPurchasedLottoStringList(List<String> lottoStringList) {
        for (String lottoString : lottoStringList) {
            System.out.println(lottoString);
        }
    }

    public static void printStatsStringList(List<String> statsStringList) {
        for (String statsString : statsStringList) {
            System.out.println(statsString);
        }
    }
}
