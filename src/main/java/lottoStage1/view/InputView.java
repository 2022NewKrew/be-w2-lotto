package lottoStage1.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return scanner.nextInt();
    }

    public static String inputLastWeekLottoNumber() {
        System.out.println(INPUT_LAST_WEEK_LOTTO_NUMBER_MESSAGE);
        return scanner.next();
    }
}
