package view;

import domain.Result;

public class ResultView {


    private Result result;

    public ResultView(Result result) {
        this.result = result;
    }

    public void showResult() {
        System.out.println("당첨 통계");
        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + prizeMoney(i) + "원)- " + result.getPrizeList()[i] + "개");
        }
        showYield();
    }

    private void showYield() {
        System.out.println("총 수익률은 " + result.totalPrizeMoney() / result.getQuantity() / 10 + "%입니다.");
    }

    private int prizeMoney(int equalNums) {
        switch (equalNums) {
            case 3:
                return 5000;
            case 4:
                return 50000;
            case 5:
                return 1500000;
            case 6:
                return 2000000000;
            default:
                return 0;
        }
    }


}
