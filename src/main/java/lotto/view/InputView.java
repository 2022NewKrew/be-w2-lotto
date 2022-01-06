package lotto.view;

import lotto.domain.message.ExceptionMessage;
import lotto.domain.message.InputViewMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputView {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private InputView() { }

    public static int inputPurchasePrice() throws IOException {
        int purchasePrice = 0;

        System.out.println(InputViewMessage.INPUT_TOTAL_PRICE.getMessage());

        try {
            purchasePrice = Integer.parseInt(input.readLine());
        } catch (Exception e) {
            System.err.println(ExceptionMessage.ERROR_INVALID_INPUT.getMessage());
            System.exit(1);
        }

        return purchasePrice;
    }

    public static String inputWinningLottoNumbers() throws IOException {
        System.out.println(InputViewMessage.INPUT_LAST_WEEK_NUMBERS.getMessage());
        return input.readLine();
    }

    public static int inputBonusBall() throws IOException {
        int bonusBall = 0;

        System.out.println(InputViewMessage.INPUT_BONUS_BALL.getMessage());

        try {
            bonusBall = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            throw new IOException(ExceptionMessage.ERROR_INVALID_INPUT.getMessage());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.ERROR_INVALID_INPUT.getMessage());
        }

        return bonusBall;
    }
}
