package lotto.view;

import lotto.domain.InputViewMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private InputView() { }

    public static int inputPurchasePrice() throws IOException {
        System.out.println(InputViewMessage.INPUT_TOTAL_PRICE.getMessage());
        return Integer.parseInt(input.readLine());
    }

    public static String inputWinningLottoNumbers() throws IOException {
        System.out.println(InputViewMessage.INPUT_LAST_WEEK_NUMBERS.getMessage());
        return input.readLine();
    }

    public static int inputBonusBall() throws IOException {
        System.out.println(InputViewMessage.INPUT_BONUS_BALL.getMessage());
        return Integer.parseInt(input.readLine());
    }
}
