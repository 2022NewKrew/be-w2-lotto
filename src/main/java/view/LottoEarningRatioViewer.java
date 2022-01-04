package view;

public class LottoEarningRatioViewer {
    public LottoEarningRatioViewer() { }

    public static void viewEarningRatio(double earned){
        String sb = "총 수익률은 " + earned + "% 입니다.";
        System.out.println(sb);
    }
}
