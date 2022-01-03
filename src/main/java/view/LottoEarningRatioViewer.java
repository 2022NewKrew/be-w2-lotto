package view;

public class LottoEarningRatioViewer {
    public LottoEarningRatioViewer() { }

    public void viewEarningRatio(long earned){
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ");
        sb.append(earned);
        sb.append("% 입니다.");

        System.out.println(sb);
    }
}
