package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoUI {
    private static final String HOW_MONEY = "구입금액을 입력해 주세요.";
    private static final String BUY_RESULT = "%d개를 구매했습니다.\n";
    private static final String LAST_WINNING_NUM = "\n지난 주 당첨 번호를 입력해주세요.";
    private static final String WINNING_RESULT = "당첨 통계\n---------\n3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n5개 일치 (1500000원)- %d개\n6개 일치 (2000000000원)- %d개\n총 수익률은 %d%%입니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static long inputMoney(){
        System.out.println(HOW_MONEY);
        long money;
        try {
            String input = scanner.nextLine();
            money = Long.parseLong(input);
        } catch (Exception e) {
            money = 0;
        }
        return money;
    }

    public static void outputLotto(int count, String lotto){
        System.out.printf(BUY_RESULT, count);
        System.out.println(lotto);
    }

    public static List<Integer> inputWinningNum(){
        System.out.println(LAST_WINNING_NUM);
        String input = scanner.nextLine();

        String replace = input.replace(" ", "");

        return Arrays.stream(replace.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
    }

    // 당첨 통계
}
