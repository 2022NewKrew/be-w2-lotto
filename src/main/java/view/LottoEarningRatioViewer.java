package view;

public class LottoEarningRatioViewer {
    private LottoEarningRatioViewer() {
    }

    public static void view(double earningRatio) {
        System.out.println("총 수익률은 " + Math.round(earningRatio * 100 * 100) / 100.0 + "% 입니다.");
    }
}
