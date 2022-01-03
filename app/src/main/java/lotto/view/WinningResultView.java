package lotto.view;

import lotto.dto.WinningResultResponse;

public class WinningResultView {

    private final WinningResultResponse response;

    private WinningResultView(WinningResultResponse winningResultResponse) {
        this.response = winningResultResponse;
    }

    public static WinningResultView createWinningResultView(WinningResultResponse response) {
        return new WinningResultView(response);
    }

    public void printView() {
        System.out.println("당첨 통계");
        System.out.println("-------------");
        System.out.println(3+"개 일치 (5000원)- "+response.getWinningResult().get(3)+"개");
        System.out.println(4+"개 일치 (50000원)- "+response.getWinningResult().get(4)+"개");
        System.out.println(5+"개 일치 (1500000원)- "+response.getWinningResult().get(5)+"개");
        System.out.println(6+"개 일치 (2000000000원)- "+response.getWinningResult().get(6)+"개");
        System.out.println("총 수익률은 "+response.getEarningRate()+"%입니다");
    }
}
