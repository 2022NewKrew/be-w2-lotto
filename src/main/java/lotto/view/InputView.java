package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {
    private static final String INPUT_TOTAL_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private InputView() { }

    public static int inputpurchasePrice() throws IOException {
        System.out.println(INPUT_TOTAL_PRICE);
        return Integer.parseInt(input.readLine());
    }

    public static String inputLastWeekNumbers() throws IOException {
        System.out.println(INPUT_LAST_WEEK_NUMBERS);
        return input.readLine();
    }
}
