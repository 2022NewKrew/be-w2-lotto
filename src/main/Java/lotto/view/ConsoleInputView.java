package lotto.view;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static String getBonusBall() {
        System.out.println("보너스볼을 입력해주세요.");
        return sc.next();
    }
}

