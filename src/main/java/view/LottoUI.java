package view;

import java.util.Scanner;

public class LottoUI {
    public static final String HOW_MONEY = "구입금액을 입력해 주세요.";
    public static final String BUY_RESULT = "%d개를 구매했습니다.\n";
    public static final String LAST_WINNING_NUM = "\n지난 주 당첨 번호를 입력해주세요.";
    public static final String WINNING_RESULT = "당첨 통계\n---------\n3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n5개 일치 (1500000원)- %d개\n6개 일치 (2000000000원)- %d개\n총 수익률은 %d%%입니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static long inputMoney(){
        System.out.println(HOW_MONEY);
        return scanner.nextLong();
    }

    public static void outputLotto(int count, String lotto){
        System.out.printf(BUY_RESULT, count);
        System.out.println(lotto);
    }

    // 지난 주 당첨 번호

    // 당첨 통계

}
