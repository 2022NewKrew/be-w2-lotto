package view;

public class LottoEarningRatioViewer {
    public LottoEarningRatioViewer() {
    }

    public static void viewEarningRatio(double earned) {
        System.out.println("총 수익률은 " + Math.round(earned * 100) / 100.0 + "% 입니다.");
    }
}
