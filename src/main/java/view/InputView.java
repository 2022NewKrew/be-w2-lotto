package view;

import domain.Money;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String WINNING_NUMBERS_SPLIT = ",";

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Money inputMoney() throws IOException {
        System.out.println(INPUT_MONEY_MESSAGE);
        return new Money(Integer.parseInt(br.readLine()));
    }

    public static List<Integer> inputWinningNumbers() throws IOException {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);

        String[] winningNumbers = br.readLine().split(WINNING_NUMBERS_SPLIT);

        return Arrays.stream(winningNumbers)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int inputBonusNumber() throws IOException {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return Integer.parseInt(br.readLine());
    }
}
