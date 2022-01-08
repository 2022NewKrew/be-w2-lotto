package lotto.view;

import java.util.*;

public class ConsoleInputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getLottoPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static String getLastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 로또 번호를 입력해주세요.");
        return sc.next();
    }

    public static long getManualCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextLong();
    }

    public static String getBonusBall() {
        System.out.println("보너스볼을 입력해주세요.");
        return sc.next();
    }

    public static String getManualLottoNumbers(long manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < manualLottoCount; i++) {
             stringBuilder.append(sc.next() + System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

