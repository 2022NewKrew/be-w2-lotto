package view;

import domain.Money;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_COUNT_OF_MANUAL_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String NUMBERS_SPLIT = ",";

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int inputMoney() throws IOException {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(br.readLine());
    }

    public static int inputCountOfManual() throws IOException {
        System.out.println(INPUT_COUNT_OF_MANUAL_MESSAGE);
        return Integer.parseInt(br.readLine());
    }

    public static List<List<Integer>> inputManualLottos(int count) throws IOException {
        if (count < 0) {
            return null;
        } else if (count > 0) {
            System.out.println(INPUT_MANUAL_NUMBERS_MESSAGE);
        }
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottos.add(inputManualNumbers());
        }
        return manualLottos;
    }

    public static List<Integer> inputManualNumbers() throws IOException {
        String[] manualNumbers = br.readLine().split(NUMBERS_SPLIT);

        return Arrays.stream(manualNumbers)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static List<Integer> inputWinningNumbers() throws IOException {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);

        String[] winningNumbers = br.readLine().split(NUMBERS_SPLIT);

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
