package lotto.view;

import java.util.Scanner;

public class IO {
    private static Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 금액을 입력해주세요.";

    private static final String aBuyNums = "%d개를 구매했습니다.";
    private static final String aResults = "당첨통계\n--------";
    private static final String aResultsPerNum = "%개 일 (%d원) - %d개";

    private static final int lottoPrice = 1000;

    public IO() {
    }

    public int start(){
        int amount = enterPurchaseAmount();
        int itemCnt = printAndGetAmount(amount);
        return itemCnt;
    }

    private int enterPurchaseAmount(){
        System.out.println(qPrice);
        int amount = scanner.nextInt();
        return amount;
    }
    private int printAndGetAmount(int money){
        int itemCnt = money/lottoPrice;
        System.out.println(String.format(aBuyNums, itemCnt));
        return itemCnt;
    }
}
