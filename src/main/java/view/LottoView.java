package view;

import java.util.Scanner;

public class LottoView {
    private final String HOW_MONEY = "구입금액을 입력해 주세요.";
    private final String BUY_RESULT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private final String HOW_MANY_MANUAL = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final String ENTER_MANUAL_NUM = "수동으로 구매할 번호를 입력해 주세요.";
    private final String LAST_WINNING_NUM = "지난 주 당첨 번호를 입력해주세요.";
    private final String BONUS_NUM = "보너스 볼을 입력해 주세요.";
    private final String WIN_RATE = "총 수익률은 %d%%입니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public String inputMoney() {
        System.out.println(HOW_MONEY);
        String money = scanner.nextLine();
        return money;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
